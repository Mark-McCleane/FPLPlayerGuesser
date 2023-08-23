package com.example.fantasyfootballgame.adapter

import android.content.Context
import android.widget.ArrayAdapter

class FplPlayerGuesserAutofillAdapter(
    context: Context,
    resource: Int,
    fplPlayerNameList: List<String>,
) : ArrayAdapter<String>(context, resource, fplPlayerNameList)