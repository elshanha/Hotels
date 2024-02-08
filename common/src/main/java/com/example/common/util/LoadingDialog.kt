package com.example.common.util

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import com.example.common.databinding.DialogLoadingBinding

class LoadingDialog(context : Activity) : Dialog(context) {
    private var binding : DialogLoadingBinding = DialogLoadingBinding.inflate(LayoutInflater.from(context))

    init {
        if(context is Activity)
            setOwnerActivity(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}