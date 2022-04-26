package com.example.calculator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.calculator.R
import com.example.calculator.databinding.CalculatorFragmentBinding
import com.example.calculator.viewmodel.CalculatorViewModel

class CalculatorFragment : Fragment() {
    private lateinit var binding: CalculatorFragmentBinding
    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.calculator_fragment, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.plus.setOnClickListener {
            val value: String = binding.editText.text.toString()
            viewModel.sign = "+"
            viewModel.firstValue = value.toFloat()
            binding.editText.text = null
        }

        binding.minus.setOnClickListener {
            val value: String = binding.editText.text.toString()
            viewModel.sign = "-"
            viewModel.firstValue = value.toFloat()
            binding.editText.text = null
        }

        binding.division.setOnClickListener {
            val value: String = binding.editText.text.toString()
            viewModel.sign = "÷"
            viewModel.firstValue = value.toFloat()
            binding.editText.text = null
        }

        binding.multiply.setOnClickListener {
            val value: String = binding.editText.text.toString()
            viewModel.sign = "×"
            viewModel.firstValue = value.toFloat()
            binding.editText.text = null
        }

        binding.calculate.setOnClickListener {
            val value: String = binding.editText.text.toString()
            viewModel.secondValue = value.toFloat()
            if(viewModel.sign == "÷" &&  viewModel.secondValue == 0.0f){
                Toast.makeText(context, "На ноль делить нельзя!", Toast.LENGTH_SHORT).show()
                viewModel.clear()
                binding.editText.text = null
            }else{
                viewModel.calculate()
                viewModel.sign = ""
                binding.editText.setText(viewModel.firstValue.toString())
            }
        }

        binding.clear.setOnClickListener {
            viewModel.clear()
            binding.editText.text = null
        }
    }
}

