package com.example.use_sqlite.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.use_sqlite.MainActivity;
import com.example.use_sqlite.Model.Student;
import com.example.use_sqlite.R;
import com.example.use_sqlite.data.DBStudent;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {

    private Context context;
    private List<Student> arrayList;
    private int resource;
    private DBStudent dbStudent;

    /*customButtonListener customListner;

    public interface customButtonListener {
        public void onButtonClickListner(int position,String value);
    }

    public void setCustomButtonListner(customButtonListener listener) {
        this.customListner = listener;
    }*/
    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects, @NonNull DBStudent dbStudent) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.resource = resource;
        this.dbStudent = dbStudent;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_list_student, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_Name);
            viewHolder.tvAddress = (TextView) convertView.findViewById(R.id.tv_Address);
            viewHolder.tvPhoneNumber = (TextView) convertView.findViewById(R.id.tv_Phone);
            viewHolder.tvEmail = (TextView) convertView.findViewById(R.id.tv_Email);
            viewHolder.imageViewDelete = (ImageView) convertView.findViewById(R.id.delete);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Student student = arrayList.get(position);
        viewHolder.tvId.setText(student.getID() + "");
        viewHolder.tvName.setText(student.getName());
        viewHolder.tvAddress.setText(student.getAddress());
        viewHolder.tvPhoneNumber.setText(student.getPhone_Number());
        viewHolder.tvEmail.setText(student.getEmail());

        viewHolder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id = viewHolder.tvId.getText() + "";
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("Alert!");
                builder.setMessage("Do you want to delete this student?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbStudent.deleteStudent(Integer.valueOf(id));
                        viewHolder.tvId.setText("");
                        viewHolder.tvName.setText("");
                        viewHolder.tvAddress.setText("");
                        viewHolder.tvPhoneNumber.setText("");
                        viewHolder.tvEmail.setText("");
                        arrayList.clear();
                        arrayList.addAll(dbStudent.getAllStudent());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });

        return convertView;
    }


    public class ViewHolder
    {
        private TextView tvId;
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvPhoneNumber;
        private TextView tvEmail;
        private ImageView imageViewDelete;
    }
}
