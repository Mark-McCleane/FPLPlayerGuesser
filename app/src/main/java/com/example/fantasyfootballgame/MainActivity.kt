package com.example.fantasyfootballgame

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.fantasyfootballgame.adapter.FplPlayerGuesserAutofillAdapter
import com.example.fantasyfootballgame.db.FplDatabase
import com.example.fantasyfootballgame.model.BoostrapStatic.FplEvent
import com.example.fantasyfootballgame.model.BoostrapStatic.FplPlayer
import com.example.fantasyfootballgame.repository.FplEventRepository
import com.example.fantasyfootballgame.repository.FplPlayerRepository
import com.example.fantasyfootballgame.utils.FplConstants
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class MainActivity : AppCompatActivity() {
    private lateinit var playerImageView: ImageView
    private var mCorrectGuess: Boolean = false
    private var mRandomPlayer: String? = null
    private var mRandomElement: FplPlayer? = null
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var mEmptyPlayerListErrorLogger: TextView
    private lateinit var gameweekHeadingTv: TextView
    private lateinit var playerGuesserAutoCompleteTextView: MaterialAutoCompleteTextView
    private lateinit var submitButton: MaterialButton
    private lateinit var mInGamePlayerList: List<FplPlayer>
    private lateinit var mInGameEventList: List<FplEvent>
    private lateinit var mAdapter: FplPlayerGuesserAutofillAdapter
    private lateinit var mFullNameList: List<String>
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
        getData()
    }

    override fun onStart() {
        super.onStart()
        setUpViews()
    }

    private fun setRandomPlayer() {
        if (mFullNameList.isNotEmpty()) {
            val randomInt = (0..mFullNameList.size).random()
            mRandomPlayer = mFullNameList[randomInt]
            mRandomElement = mInGamePlayerList[randomInt]
            loadImage(mRandomElement?.photo)
        }
    }

    private fun setUpViews() {
        mEmptyPlayerListErrorLogger = findViewById(R.id.empty_recycler_view_error_logger)
        gameweekHeadingTv = findViewById(R.id.text_gameweek_heading)
        playerGuesserAutoCompleteTextView = findViewById(R.id.autoCompleteText_player)
        submitButton = findViewById(R.id.btn_submit_guess)
        playerImageView = findViewById(R.id.image_player_avatar)

//        mFullNameList = viewModel.getFullNameList(mInGamePlayerList)
        mFullNameList = mInGamePlayerList.map { it.webName }
        mAdapter = FplPlayerGuesserAutofillAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            mFullNameList
        )
        playerGuesserAutoCompleteTextView.setAdapter(mAdapter)

        playerGuesserAutoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                submitButton.visibility = View.VISIBLE
            }

        submitButton.setOnClickListener {
            counter++
            checkIfTrue(it)
        }
    }

    private fun checkIfTrue(view: View) {
        val snackbar: Snackbar?
        if (playerGuesserAutoCompleteTextView.text.toString().trim() == mRandomPlayer?.trim()) {
            snackbar = Snackbar.make(
                view,
                getString(R.string.the_user_is_a_winner, counter),
                Snackbar.LENGTH_INDEFINITE
            )
            mCorrectGuess = true
            hideKeyboard(view)
        } else if (counter >= 7) {
            snackbar = Snackbar.make(
                view,
                getString(
                    R.string.the_user_is_a_loser,
                    mRandomElement?.firstName,
                    mRandomElement?.secondName
                ),
                Snackbar.LENGTH_INDEFINITE
            )
            hideKeyboard(view)
            submitButton.visibility = View.GONE
            mCorrectGuess = true
        } else {
            playerGuesserAutoCompleteTextView.setText("")
            submitButton.visibility = View.GONE
            snackbar = Snackbar.make(
                view,
                getString(R.string.incorrect_please_try_again),
                Snackbar.LENGTH_SHORT
            )
        }
        displayPlayerItem()
        snackbar.show()
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun displayPlayerItem() {
        val playerNameTextView: TextView = findViewById(R.id.text_player_web_name)
        val fplPointsTextView: TextView = findViewById(R.id.text_player_points)
        val fplPositionTextView: TextView = findViewById(R.id.text_player_position)
        val teamTextView: TextView = findViewById(R.id.text_team)

        val mFplPlayerPosition: String = viewModel.convertPositionIdToFplPosition(mRandomElement)
        val mFplPlayerTeam: String = viewModel.convertTeamIdToFplTeam(mRandomElement)

        if (mCorrectGuess) {
            playerNameTextView.text =
                getString(
                    R.string.player_name_in_display_player_item,
                    mRandomElement?.firstName,
                    mRandomElement?.secondName
                )
            fplPointsTextView.text =
                getString(R.string.fpl_points_in_display_player_item, mRandomElement?.totalPoints)
            fplPositionTextView.text =
                getString(R.string.fpl_position_in_display_player_item, mFplPlayerPosition)
            teamTextView.text =
                getString(R.string.team_in_display_player_item, mFplPlayerTeam)
        }
        when (counter) {
            2 -> {
                teamTextView.text =
                    getString(R.string.team_in_display_player_item, mFplPlayerTeam)
            }

            3 -> {
                fplPointsTextView.text =
                    getString(
                        R.string.fpl_points_in_display_player_item,
                        mRandomElement?.totalPoints
                    )

            }

            4 -> {
                fplPositionTextView.text =
                    getString(R.string.fpl_position_in_display_player_item, mFplPlayerPosition)
            }
        }
    }

    private fun loadImage(photo: String?) {
        val photoInPng = photo?.replace(".jpg", ".png")
        Glide.with(this).load(FplConstants.BASE_IMG_URL + photoInPng).into(playerImageView)
    }

    private fun getData() {
        viewModel.getElementsFromRoom().observe(this, Observer { newPlayerList ->
            mInGamePlayerList = newPlayerList
            if (mInGamePlayerList.isEmpty()) {
                mEmptyPlayerListErrorLogger.visibility = View.VISIBLE
            } else {
                mEmptyPlayerListErrorLogger.visibility = View.GONE
            }

            mFullNameList = mInGamePlayerList.map { it.webName }

            if (mRandomPlayer.isNullOrEmpty()) {
                setRandomPlayer()
            }

            mAdapter.refreshData(mFullNameList)
        })

        viewModel.getFplEventsFromRoom().observe(this, Observer { events ->
                if (events.isNotEmpty()) {
                    mInGameEventList = events
                    val currentGame = events.find { it.isCurrent }
                    currentGame?.let { gameweekHeadingTv.text = it.name }
                    }
                })
    }

    private fun setUpViewModel() {
        val fplPlayerRepository = FplPlayerRepository(FplDatabase(this))
        val fplEventRepository = FplEventRepository(FplDatabase(this))
        val viewModelProviderFactory =
            MainActivityViewModelProviderFactory(fplPlayerRepository, fplEventRepository)
        mInGamePlayerList = emptyList()
        viewModel =
            ViewModelProvider(this, viewModelProviderFactory)[MainActivityViewModel::class.java]
    }
}