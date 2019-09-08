package com.kv.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    android.widget.ExpandableListAdapter expandableListAdapter;
    ArrayList<String> expandableListTitle = new ArrayList<>();
//    HashMap<String, List<String>> expandableListDetail;

    RetorentDetail retorentDetail = new RetorentDetail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDummyData();
        init();
    }

    private void setDummyData() {
        ArrayList<RetorentDetail.Menuitems> parentitemlist = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            RetorentDetail retorentDetailtmp = new RetorentDetail();
            RetorentDetail.Menuitems parentitem = retorentDetailtmp.new Menuitems();
            ArrayList<RetorentDetail.Menuitems1> items1ArrayList = new ArrayList<>();

            parentitem.setFood_type("Burger " + i);

            for (int j = 0; j < 3; j++) {
                RetorentDetail.Menuitems1 childitem = new RetorentDetail().new Menuitems1();
                childitem.setPrice(100 * j);
                childitem.setName("Chicken grilled burger" + j);
                childitem.setDescription("Burger with bla " + j);
                items1ArrayList.add(childitem);
            }
            parentitem.setMenuitems(items1ArrayList);

            parentitemlist.add(parentitem);
        }
        retorentDetail.setMenuitems(parentitemlist);

        for (int i = 0; i < retorentDetail.getMenuitems().size(); i++) {
            expandableListTitle.add(retorentDetail.getMenuitems().get(i).getFood_type());
        }

    }

    public void init() {
        expandableListView = findViewById(R.id.expandableListView);
//        expandableListDetail = SampleData.getData();
//        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());

        expandableListAdapter = new ExpandableListAdapter(this, expandableListTitle, retorentDetail.getMenuitems());
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int gP) {
//                Toast.makeText(getApplicationContext(), expandableListTitle.get(gP) + " List Expanded.", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int gP) {
                Toast.makeText(getApplicationContext(), expandableListTitle.get(gP) + " List Collapsed.", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int gP, int cP, long id) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(gP) + " -> " +
                                retorentDetail.getMenuitems().get(gP).getMenuitems().get(cP).getName(),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
