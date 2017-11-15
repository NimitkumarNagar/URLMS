package com.urlms.urlms_new.Equipment;

import android.app.Activity;
import android.app.ListActivity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.urlms.urlms_new.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;




public class RemoveEquipment extends ListActivity {

    String equip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_equipment);



        try{
            equip = getItemFromXML(this);
        }catch (XmlPullParserException e){
        }catch (IOException e){
        }

        String[] equipment = equip.split("\n");
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, equipment));
    }


    public String getItemFromXML(Activity activity) throws XmlPullParserException, IOException{
        StringBuffer stringBuffer = new StringBuffer();
        Resources res = activity.getResources();
        XmlResourceParser xpp = res.getXml(R.xml.test_data_persistence);
        xpp.next();
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT){
            if (eventType == XmlPullParser.START_TAG){
                if (xpp.getName().equals("euip")){
                    stringBuffer.append(xpp.getAttributeValue(null, "euip") + "\n");
                }
            }
            eventType = xpp.next();
        }
        return stringBuffer.toString();

    }
}

