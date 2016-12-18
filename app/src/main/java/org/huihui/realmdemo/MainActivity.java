package org.huihui.realmdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    private android.widget.TextView tv;
    private android.widget.Button btnsave;
    private android.widget.LinearLayout activitymain;
    private Realm mDefaultInstance;
    private Button btnget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnget = (Button) findViewById(R.id.btn_get);
        this.activitymain = (LinearLayout) findViewById(R.id.activity_main);
        this.btnsave = (Button) findViewById(R.id.btn_save);
        this.tv = (TextView) findViewById(R.id.tv);
        Realm.init(this);
//        mDefaultInstance = Realm.getDefaultInstance();
//        RealmConfiguration.Builder migration = new RealmConfiguration.Builder().schemaVersion(2).migration(new RealmMigration() {
//            @Override
//            public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
//                RealmSchema schema = realm.getSchema();
//                if (newVersion == 2) {
//                    RealmObjectSchema user = schema.get("User");
//                    user.addField("id", Integer.class);
//                }
//            }
//        });
//        mDefaultInstance = Realm.getInstance(migration.build());

        RealmConfiguration build = new RealmConfiguration.Builder().schemaVersion(2).deleteRealmIfMigrationNeeded().build();//可以清空数据库避免写升级脚本
        mDefaultInstance = Realm.getInstance(build);
//        mDefaultInstance.where(User.class).findAll().deleteAllFromRealm(); //Realm data can only be changed inside a write transaction. 数据改变只能在事务中
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setAge(1);
                user.setName("张三");
                mDefaultInstance.beginTransaction();
                mDefaultInstance.copyToRealm(user);
                mDefaultInstance.commitTransaction();
            }
        });
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User first = mDefaultInstance.where(User.class).findFirst();
                tv.setText(first.getName() + first.getAge() + "   " + mDefaultInstance.getVersion()
                );
            }
        });
    }
}
