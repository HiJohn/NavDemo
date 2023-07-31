package mope.emp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.combine
import mope.emp.databinding.FragmentSecBinding
import mope.emp.databinding.FragmentThirdBinding

class ThirdFragment :Fragment() {

    private lateinit var binding:FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bko.setOnClickListener {
            nav().popBackStack(R.id.blankFragment,false)

        }
    }

}