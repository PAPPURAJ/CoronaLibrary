package com.blogspot.prajbtc.coronalibrary;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class Corona {

    public static void getReport(MyResultInterface resultInterface){
        MyDownloadClass myDownloadClass=new MyDownloadClass(resultInterface);
        myDownloadClass.execute();
    }


    private static  class MyDownloadClass extends AsyncTask<Void, Void, Report>{
        MyResultInterface myResultInterface;

        public MyDownloadClass(MyResultInterface myResultInterface) {
            this.myResultInterface=myResultInterface;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }



        @Override
        protected Report doInBackground(Void... voids) {


            String html = null;
            try {
                html = Jsoup.connect("https://worldometers.info/coronavirus/").get().html();
                ArrayList<ReportList> reportLists=new ArrayList<>();
            Document document = Jsoup.parse(html);
            String country,total_cases,new_cases,total_deaths,new_deaths,total_recovered,active_cases,serious_cases,tested,population;
            Element tbody = document.getElementById("main_table_countries_today").getElementsByTag("tbody").first();
            for (int i = 0; i < tbody.getElementsByTag("tr").size(); i++) {
                Element tr = tbody.getElementsByTag("tr").get(i);

                country = tr.getElementsByTag("td").get(1).text();
                total_cases = tr.getElementsByTag("td").get(2).text();
                new_cases = tr.getElementsByTag("td").get(3).text();
                total_deaths = tr.getElementsByTag("td").get(4).text();
                new_deaths = tr.getElementsByTag("td").get(5).text();
                total_recovered = tr.getElementsByTag("td").get(6).text();
                active_cases = tr.getElementsByTag("td").get(7).text();
                serious_cases = tr.getElementsByTag("td").get(8).text();
                tested = tr.getElementsByTag("td").get(11).text();
                population = tr.getElementsByTag("td").get(13).text();

                if(total_cases.equals("") || total_cases.toLowerCase().equals("n/a")) total_cases = "0";
                if(new_cases.equals("") || new_cases.toLowerCase().equals("n/a")) new_cases = "0";
                if(total_deaths.equals("") || total_deaths.toLowerCase().equals("n/a")) total_deaths = "0";
                if(new_deaths.equals("") || new_deaths.toLowerCase().equals("n/a")) new_deaths = "0";
                if(total_recovered.equals("") || total_recovered.toLowerCase().equals("n/a")) total_recovered = "0";
                if(active_cases.equals("") || active_cases.toLowerCase().equals("n/a")) active_cases = "0";
                if(serious_cases.equals("") || serious_cases.toLowerCase().equals("n/a")) serious_cases = "0";
                if(tested.equals("") || tested.toLowerCase().equals("n/a")) tested = "0";
                Log.e("=======",country);
                reportLists.add(new ReportList(country,convertToDigit(total_cases),convertToDigit(new_cases),convertToDigit(total_deaths),convertToDigit(new_deaths),convertToDigit(total_recovered),convertToDigit(active_cases),convertToDigit(serious_cases),convertToDigit(tested),convertToDigit(population)));
            }







                return new Report(true,reportLists);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Report report) {
            super.onPostExecute(report);
            myResultInterface.Success(report);
        }


        private int convertToDigit(String input) {
            if (input == "")
                return 0;

            try {
                return Integer.parseInt(input.replaceAll("[+,]", ""));
            } catch (Exception e) {
                return -1;
            }


        }

    }
}
