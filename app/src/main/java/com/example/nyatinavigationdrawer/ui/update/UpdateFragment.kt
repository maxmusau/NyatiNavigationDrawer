package com.example.nyatinavigationdrawer.ui.update

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

class UpdateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_update, container, false)
        val id_number=view.findViewById<EditText>(R.id.id_number)
        val salary=view.findViewById<EditText>(R.id.salary)
        val update=view.findViewById<Button>(R.id.update)
        update.setOnClickListener {
            val body=JSONObject()
            //put the id and salary to the body
            body.put("id_number",id_number.text.toString())
            body.put("salary",salary.text.toString())
            val helper= ApiHelper(requireContext())
            val api="https://sofwaredev.pythonanywhere.com/employees"
            helper.put(api,body)
        }//end of onclick
        return view
    }

}