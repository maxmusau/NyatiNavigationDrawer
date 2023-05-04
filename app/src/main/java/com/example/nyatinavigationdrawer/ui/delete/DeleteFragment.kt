package com.example.nyatinavigationdrawer.ui.delete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nyatinavigationdrawer.R
import android.widget.Button
import android.widget.EditText
import com.example.nyatinavigationdrawer.ApiHelper
import org.json.JSONObject

class DeleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_delete, container, false)
        val id_number=view.findViewById<EditText>(R.id.id_number)

        val delete=view.findViewById<Button>(R.id.delete)
        delete.setOnClickListener {
            val body= JSONObject()
            //put the id and salary to the body
            body.put("id_number",id_number.text.toString())
            val helper= ApiHelper(requireContext())
            val api="https://sofwaredev.pythonanywhere.com/employees"
            helper.delete(api,body)
        }//end of onclick
        return view
    }

}