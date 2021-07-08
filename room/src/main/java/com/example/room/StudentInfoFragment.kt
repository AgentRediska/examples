package com.example.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.database_room.Student
import kotlinx.android.synthetic.main.fragment_student_info.*


class StudentInfoFragment : Fragment() {

    private lateinit var students_list: RecyclerView
    private var adapter: StudentsListAdapter?=StudentsListAdapter(emptyList())

    private val studentsListViewModel: StudentsInfoViewModel by lazy {
        ViewModelProvider(this).get(StudentsInfoViewModel::class.java)
    }

    companion object{
        fun newInstance(): StudentInfoFragment{
            return StudentInfoFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val view= inflater.inflate(R.layout.fragment_student_info, container, false)

        btnAddStudent.setOnClickListener {

        }

       students_list = view.findViewById(R.id.students_list) as RecyclerView
        students_list.layoutManager=LinearLayoutManager(context)

        btnGetStudent.setOnClickListener {
        }

        students_list.adapter=adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        studentsListViewModel.studentsListLiveData.observe(
                viewLifecycleOwner,
                Observer { students -> students?.let {
                    updateUI(students)
                    }
                }
        )
    }

    private fun updateUI(students: List<Student>){
        adapter=StudentsListAdapter(students)
        students_list.adapter=adapter
    }



    private inner class StudentHolder(view:View): RecyclerView.ViewHolder(view){
        val idStudent: TextView= view.findViewById(R.id.text_view_id_student)
        val firstNameStudent: TextView= view.findViewById(R.id.text_view_first_name_student)
        val groupStudent: TextView= view.findViewById(R.id.text_view_group_student)
        val lastNameStudent: TextView= view.findViewById(R.id.text_view_last_name_student)
    }

    private inner class StudentsListAdapter( studList: List<Student>): RecyclerView.Adapter<StudentHolder>(){
        var studentList: List<Student> =studList
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
            val view = layoutInflater.inflate(R.layout.student_view_holder, parent, false)
            return StudentHolder(view)
        }

        override fun onBindViewHolder(holder: StudentHolder, position: Int) {
            val student =studentList[position]
            holder.apply {
                idStudent.text= student.studentId.toString()
                firstNameStudent.text=student.firstName
                lastNameStudent.text=student.lastName
                groupStudent.text= student.group.toString()
            }
        }

        override fun getItemCount()= studentList.size

    }


}