package mope.emp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mope.emp.databinding.FragmentBlankBinding


/**
 * nav`s first page
 */
class MainFragment : Fragment() {


    private lateinit var binding: FragmentBlankBinding
//      TODO what`s navGraphViewModels
//    private val viewModel: NavViewModel by navGraphViewModels(R.id.nav_graph) {
//        SavedStateViewModelFactory(requireActivity().application, requireParentFragment())
//    }

    private val viewModel:NavViewModel by navSharedLazyVm()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sjn.setOnClickListener {
            val args  = Bundle()
            args.putBoolean("testBool",true)
            args.putString("testStr","sayHey")
            nav().navigate(R.id.to_page_2,args)
        }
        binding.cda.setOnClickListener {
            viewModel.netName.postValue("Not a name")
        }

        viewModel.netName.observe(requireActivity()){
            binding.show.text = it
        }

//        lifecycleScope.launchWhenCreated {
//            viewModel.netName.collect() {
//
//            }
//        }


    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}