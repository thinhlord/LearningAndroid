package com.example.thinh.learning;

import android.app.ListActivity;


public class DbTestActivity extends ListActivity {
        /*
    ContactListModel database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_test);

        database = new ContactListModel(this);
        database.open();
        final List<String> contactListName = database.getContactListName();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, contactListName);
        final ListView listView = getListView();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    final int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                contactListName.remove(item);
                                database.deleteContact(position);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });

        Button addButton = (Button) findViewById(R.id.button_send);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                database.addContact("Thinh", "VIP");
                contactListName.add("Thinh");
                adapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.db_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        database.close();
        super.onDestroy();
    }

    public void dropDb(View view) {
        database.dropDb();

    }*/
}
