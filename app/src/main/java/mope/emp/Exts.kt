package mope.emp

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navGraphViewModels


fun logs(log:String){
    Log.d("barry",log)
}
fun Fragment.navGraphLazyVm(): Lazy<NavViewModel> {
    return  navGraphViewModels(R.id.nav_graph) {
        SavedStateViewModelFactory(requireActivity().application, requireParentFragment())
    }

}

fun Fragment.navSharedLazyVm(): Lazy<NavViewModel> {
    return lazy  {
        ViewModelProvider(requireActivity())[NavViewModel::class.java]
    }
}

fun Fragment.toast(text:String){
    Toast.makeText(this.context,text,Toast.LENGTH_SHORT).show()
}

fun Fragment.nav(): NavController {
    return NavHostFragment.findNavController(this)
}

fun nav(view: View): NavController {
    return Navigation.findNavController(view)
}

fun Fragment.navViewModel(): NavViewModel {
    val viewModel: NavViewModel by navGraphViewModels(R.id.nav_graph) {
        SavedStateViewModelFactory(requireActivity().application, requireParentFragment())
    }
    return viewModel
}

fun AndroidViewModel.nav(fragment: Fragment): NavController {
    return NavHostFragment.findNavController(fragment)
}