package com.example.use_sqlite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.use_sqlite.Model.Student;
import com.example.use_sqlite.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {

    private Context context;
    private List<Student> arrayList;
    private int resource;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       ViewHolder viewHolder;
       if(convertView==null)
       {
           convertView = LayoutInflater.from(context).inflate(R.layout.row_list_student,parent,false);
           viewHolder=new ViewHolder();
           viewHolder.tvId=(TextView)convertView.findViewById(R.id.tv_id);
           viewHolder.tvName=(TextView)convertView.findViewById(R.id.tv_Name);
           viewHolder.tvAddress=(TextView)convertView.findViewById(R.id.tv_Address);
           viewHolder.tvPhoneNumber=(TextView)convertView.findViewById(R.id.tv_Phone);
           viewHolder.tvEmail=(TextView)convertView.findViewById(R.id.tv_Email);

           convertView.setTag(viewHolder);
       }else{
           viewHolder=(ViewHolder)convertView.getTag();
       }
       Student student=arrayList.get(position);
       viewHolder.tvId.setText(student.getID()+"");
       viewHolder.tvName.setText(student.getName());
       viewHolder.tvAddress.setText(student.getAddress());
       viewHolder.tvPhoneNumber.setText(student.getPhone_Number());
       viewHolder.tvEmail.setText(student.getEmail());


        return convertView;
    }
    public class ViewHolder
    {
        private TextView tvId;
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvPhoneNumber;
        private TextView tvEmail;
    }
}
