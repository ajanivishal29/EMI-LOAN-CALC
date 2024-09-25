package com.financecalculator.emicalcutator.meghachem.SIKKOConvert;

import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

public class GetNationData extends AsyncTask<Void, Void, Exception> {

    public static SortedMap<Currency, ArrayList<Locale>> f33791f = new TreeMap(new a());
    public static HashMap<String, Double> f33792g;
    public static Calendar f33793h;
    public static final double f33794i = Math.cos(Math.toRadians(45.0d));
    public final C0464c f33795a;
    public final String f33796b;
    public Double f33797c = null;
    public final double f33798d;
    public final String f33799e;

    public static class a implements Comparator<Currency> {
        public int compare(Currency currency, Currency currency2) {
            return currency.getCurrencyCode().compareTo(currency2.getCurrencyCode());
        }
    }

    public interface C0464c {
        void a(Double d10, Exception exc);
    }

    static {
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency instance = Currency.getInstance(locale);
                if (!f33791f.containsKey(instance)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(locale);
                    f33791f.put(instance, arrayList);
                } else {
                    f33791f.get(instance).add(locale);
                }
            } catch (Exception unused) {
            }
        }
    }

    public GetNationData(double d10, String str, String str2, C0464c cVar) {
        this.f33798d = d10;
        this.f33799e = str;
        this.f33796b = str2;
        this.f33795a = cVar;
    }

    public static Double a(Double d10, String str, String str2) throws Exception {
        Double d11 = f33792g.get(str);
        Double d12 = f33792g.get(str2);
        if (d11 == null || d12 == null) {
            throw new Exception("Currency not found.");
        }
        double doubleValue = d11.doubleValue();
        double d13 = f33794i;
        if (doubleValue != d13) {
            d13 = (d12.doubleValue() / d11.doubleValue()) * d10.doubleValue();
        }
        return Double.valueOf(d13);
    }

    public static void b(double d10, String str, String str2, C0464c cVar) {
        if (n()) {
            new GetNationData(d10, str, str2, cVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        try {
            cVar.a(a(Double.valueOf(d10), str, str2), (Exception) null);
        } catch (Exception e10) {
            e10.printStackTrace();
            cVar.a((Double) null, e10);
        }
    }

    public static String e(String str, double d10) {
        Currency instance = Currency.getInstance(str);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.getDefault());
        currencyInstance.setCurrency(instance);
        return currencyInstance.format(d10);
    }

    public static void g() throws Exception {
        HashMap<String, Double> hashMap = new HashMap<>();
        f33792g = hashMap;
        hashMap.put("BRL", Double.valueOf(1.0d));
        JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL("http://www.floatrates.com/daily/brl.json").openStream()));
        jsonReader.setLenient(true);
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            jsonReader.nextName();
            jsonReader.beginObject();
            double d10 = f33794i;
            String str = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.getClass();
                if (nextName.equals("code")) {
                    str = jsonReader.nextString();
                } else if (!nextName.equals("rate")) {
                    jsonReader.skipValue();
                } else {
                    d10 = jsonReader.nextDouble();
                }
            }
            jsonReader.endObject();
            if (str != null) {
                f33792g.put(str, Double.valueOf(d10));
            }
        }
        jsonReader.endObject();
        f33793h = Calendar.getInstance();
    }

    public static List<Currency> h() {
        return new ArrayList(f33791f.keySet());
    }

    public static ArrayList<Locale> i(Currency currency) {
        return f33791f.get(currency);
    }

    public static String j(String str) {
        Currency instance = Currency.getInstance(str);
        return f33791f.get(instance).size() > 0 ? instance.getSymbol((Locale) f33791f.get(instance).get(0)) : "";
    }

    public static boolean n() {
        if (f33793h == null) {
            return true;
        }
        Calendar instance = Calendar.getInstance();
        return !(f33793h.get(1) == instance.get(1) && f33793h.get(6) == instance.get(6));
    }

    public Exception doInBackground(Void... voidArr) {
        try {
            g();
            this.f33797c = a(Double.valueOf(this.f33798d), this.f33799e, this.f33796b);
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return e10;
        }
    }

    public String k(String str, Number number) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.getDefault());
        currencyInstance.setCurrency(Currency.getInstance(str));
        return currencyInstance.format(number);
    }

    public void onPostExecute(Exception exc) {
        this.f33795a.a(this.f33797c, exc);
    }

    public void onPreExecute() {
        this.f33797c = null;
    }
}
