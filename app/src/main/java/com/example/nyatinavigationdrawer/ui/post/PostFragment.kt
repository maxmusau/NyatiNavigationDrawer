package com.example.nyatinavigationdrawer.ui.post

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

class PostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_post, container, false)
        var id_number=view.findViewById<EditText>(R.id.id_number)
        var username=view.findViewById<EditText>(R.id.username)
        var others=view.findViewById<EditText>(R.id.others)
        var salary=view.findViewById<EditText>(R.id.salary)
        var department=view.findViewById<EditText>(R.id.department)
        var save =view.findViewById<Button>(R.id.save)
        save.setOnClickListener {
            val body=JSONObject()
            body.put("id_number",id_number.text.toString())
            body.put("username",username.text.toString())
            body.put("others",others.text.toString())
            body.put("salary",salary.text.toString())
            body.put("department",department.text.toString())
            //access the APiHelper -Loopj
            val helper= ApiHelper(requireContext())
            //ddefine the api
            val api="https://sofwaredev.pythonanywhere.com/employees"
            //pass the body and api to the apihelper
            helper.post(api,body)
            //Done
        }
        return view
    }

}