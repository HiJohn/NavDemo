package mope.emp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mope.emp.databinding.FragmentSecBinding

/**
 * nav`s second page
 */
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecBinding

    private val viewModel:NavViewModel by navSharedLazyVm()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var testBool = false
        var testStr = ""
        arguments?.let {
            testBool = it.getBoolean("testBool")
            testStr = it.getString("testStr") ?: ""
        }

        logs("pass args : $testBool and $testStr")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tot.setOnClickListener {
            nav().navigate(R.id.to_page_3)
        }

        binding.change.setOnClickListener {
            viewModel.netName.postValue("Barry")
        }
        viewModel.netName.observe(requireActivity()){
            binding.show2.text  = it
        }

        binding.show2.text = viewModel.netName.value
    }

}