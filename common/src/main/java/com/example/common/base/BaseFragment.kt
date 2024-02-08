package com.example.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.common.Status
import com.example.common.util.LoadingDialog
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
abstract class BaseFragment<B: ViewBinding>(private val inflate: Inflate<B>) : Fragment() {

    private var _binding : ViewBinding? = null
    protected val binding : B get() = _binding as B

    private lateinit var loadingDialog: LoadingDialog

    abstract fun mViewModel() : BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            loadingDialog = LoadingDialog(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleState()
    }

    private fun handleState() {
        lifecycleScope.launch {
            mViewModel().state.collectLatest {state->
                state?.let {
                    when(it.status) {
                        Status.SUCCESS -> showLoadingProgress(false)
                        Status.ERROR -> showLoadingProgress(false)
                        Status.LOADING -> showLoadingProgress(true)
                    }
                }
            }
        }
    }



    private fun showLoadingProgress(isLoad : Boolean) {
        if(::loadingDialog.isInitialized) { // lateinit tanımlanmış ama oluşturulmamışsa
            loadingDialog.apply {
                if(isLoad) {
                    if(!isShowing && isAdded) // isAdded içinde bulunduğunuz fragment'ın görünür oılup olmadı.
                        show()
                } else {
                    if(isShowing) dismiss()
                }
            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}