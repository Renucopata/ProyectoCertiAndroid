package com.first.mascotapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.first.mascotapp.R
import com.first.mascotapp.databinding.FragmentVetsBinding
import com.first.mascotapp.fragments.viewModels.ServicesViewModel
import com.first.mascotapp.models.ServiceListItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PeluqueriasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PeluqueriasFragment : Fragment() { lateinit var binding: FragmentVetsBinding

    val servicesViewModel: ServicesViewModel by activityViewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVetsBinding.inflate(inflater, container, false)
        binding.servicesViewModel = servicesViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listItems = listOf(
            ServiceListItem(
                "Elemento 1",
                "Descripcion 1 aaaaaaaaaaaaaaaaaa",
                "https://images.unsplash.com/photo-1583336663277-620dc1996580?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8ZG9nJTIwY2xvdGhlc3xlbnwwfHwwfHw%3D&w=1000&q=80",
                "https://media.istockphoto.com/id/908909714/pt/vetorial/vector-group-of-pets-dog-cat-parrot-on-white-background-beautiful-pet-symbol-pet-icon-easy.jpg?s=612x612&w=0&k=20&c=MobzGBzk0u9-ghIwcQi1ujJtapkFf0gIrqFrjoWRTL0=",
                "Contact 1"
            ),
            ServiceListItem(
                "Elemento 2",
                "Descripcion 2 aaaaaaaaaaaaaaaaaa",
                "https://sgp1.digitaloceanspaces.com/tz-mag-ph/wp-content/uploads/2022/01/111101015151/best-minimalist-jewelry-brands-770x404.jpg",
                "https://www.logodesign.net/images/home-industry/jewelry-logo-02.jpg",
                "Contact 2"

            ),
            ServiceListItem(
                "Elemento 3",
                "Descripcion 3 aaaaaaaaaaaaaaaaaa",
                "https://di2ponv0v5otw.cloudfront.net/posts/2020/09/23/5f6bc0651e75a87ebf64c88f/m_5f6bc06ca4de414bb929718d.jpeg",
                "https://media.istockphoto.com/id/874045548/vector/shirt-icon.jpg?s=612x612&w=0&k=20&c=ZJCxsCczemu1XhYRMDCByrYdwotBESuFdC5tkGf1a6g=",
                "Contact 3"
            )
        )

    }

}