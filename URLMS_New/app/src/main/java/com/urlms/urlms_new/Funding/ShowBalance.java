package com.urlms.urlms_new.Funding;


import android.os.Bundle;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


import android.app.Activity;
import android.app.ListActivity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;

import android.widget.ArrayAdapter;

import com.urlms.urlms_new.R;

public class ShowBalance extends ListActivity {

    String fund;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_balance);



        try{
            fund = getItemFromXML(this);
        }catch (XmlPullParserException e){
        }catch (IOException e){
        }

        String[] funds = fund.split("\n");
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, funds));
    }


    public String getItemFromXML(Activity activity) throws XmlPullParserException, IOException{
        StringBuffer stringBuffer = new StringBuffer();
        Resources res = activity.getResources();
        XmlResourceParser xpp = res.getXml(R.xml.test_data_persistence);
        xpp.next();
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT){
            if (eventType == XmlPullParser.START_TAG){
                if (xpp.getName().equals("fundAccount")){
                    stringBuffer.append(xpp.getAttributeValue(null, "fundAccount") + "\n");
                }
            }
            eventType = xpp.next();
        }
        return stringBuffer.toString();

    }
}
