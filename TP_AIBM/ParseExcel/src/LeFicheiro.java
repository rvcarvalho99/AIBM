import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

import static java.lang.StrictMath.floor;

public class LeFicheiro {

    private  static Dates dates = new Dates();
    private  static District district = new District();
    private  static Cause cause = new Cause();
    private  static Prof prof = new Prof();
    private  static Color color = new Color();
    private  static Destination destination = new Destination();
    private  static Reason reason = new Reason();
    private  static Genders genders = new Genders();
    private  static List<Admition> admitions= new ArrayList<>();
    private  static List<Triage> triage= new ArrayList<>();
    private  static List<Diagnosis> diagnosis = new ArrayList<>();
    private  static List<DiagnosisCode> diagnosiscode = new ArrayList<>();
    private  static List<Discharge> discharges = new ArrayList<>();
    private  static List<Episódio> episódios = new ArrayList<>();
    private  static Map<Integer,Integer> examwithEP = new HashMap<>();
    private  static List<Exam> exam = new ArrayList<>();
    private  static Map<Integer,Integer> prescripwithEP = new HashMap<>();
    private  static List<Prescription> prescription = new ArrayList<>();
    private  static Map<Integer,Integer> procedwithEP = new HashMap<>();
    private  static List<Procedure> procedure = new ArrayList<>();
    private  static Map<Integer,String> interventions = new HashMap<>();
    private  static List<Hierarchy> hier = new ArrayList<>();
    private  static Map<String,Integer> hierID = new HashMap<>();
    private  static Set<String> error = new HashSet<>();

    public static String trataDatas(String data){

        String[] dat = data.split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(dat[2]).append("-").append(trataDatasMes(dat[1])).append("-").append(dat[0]);
        return sb.toString();
    }

    public static String trataDatasMes(String data){

       
        switch (data){
                case "janeiro":
                    data = "01";
                    break;
                case "fevereiro":
                    data = "02";
                    break;
                case "março":
                    data = "03";
                    break;
                case "abril":
                    data = "04";
                    break;
                case "maio":
                    data = "05";
                    break;
                case "junho":
                    data = "06";
                    break;
                case "julho":
                    data = "07";
                    break;
                case "agosto":
                    data = "08";
                    break;
                case "setembro":
                    data = "09";
                    break;
                case "outubro":
                    data = "10";
                    break;
                case "novembro":
                    data = "11";
                    break;
                case "dezembro":
                    data = "12";
                    break;

                default:
                    break;
            }
            return data;
    }


    public static void lediagnosis() throws IOException {


        int joinexam=0;
        double total = 9810;
        int lastpercentage = 0;
        File file = new File("icd9_hierarchy.xlsx");   //creating a new file instance
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
        //creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        Iterator<Sheet> sheets = wb.iterator();
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        StringBuilder sb = new StringBuilder();
        double i = 0;
        while (sheets.hasNext()) {
            boolean changed = true;
            Sheet sh = sheets.next();
            String name = sh.getSheetName();
            System.out.println("\nFicheiro " + name + "\n");
            itr = sh.rowIterator();
            Row row = itr.next();
            while (itr.hasNext()) {
                row = itr.next();
                if (changed)
                    System.out.println(lastpercentage + "%");
                changed = false;
                boolean nulls = false;

                //int epnum = (int) Double.parseDouble(row.getCell(0).toString());
                Hierarchy hi = new Hierarchy();
                hi.setLevel1desc(row.getCell(1).toString());
                if(row.getCell(8)!=null){
                    try{
                    hi.setCode(String.valueOf(Double.parseDouble(row.getCell(8).toString())));
                    }
                    catch (Exception e){
                        hi.setCode(row.getCell(8).toString());
                    }
                    hi.setLevel5desc(row.getCell(9).toString());
                    hi.setLevel4desc(row.getCell(7).toString());
                    hi.setLevel3desc(row.getCell(5).toString());
                    hi.setLevel2desc(row.getCell(3).toString());
                }
                else if(row.getCell(6)!=null){
                    try{
                        hi.setCode(String.valueOf(Double.parseDouble(row.getCell(6).toString())));
                    }
                    catch (Exception e){
                        hi.setCode(row.getCell(6).toString());
                    }
                    hi.setLevel4desc(row.getCell(7).toString());
                    hi.setLevel3desc(row.getCell(5).toString());
                    hi.setLevel2desc(row.getCell(3).toString());
                }else if(row.getCell(4)!=null){
                    try{
                        hi.setCode(String.valueOf(Double.parseDouble(row.getCell(4).toString())));
                    }
                    catch (Exception e){
                        hi.setCode(row.getCell(4).toString());
                    }
                    hi.setLevel3desc(row.getCell(5).toString());
                    hi.setLevel2desc(row.getCell(3).toString());
                }else {
                    try{
                        hi.setCode(String.valueOf(Double.parseDouble(row.getCell(2).toString())));
                    }
                    catch (Exception e){
                        hi.setCode(row.getCell(2).toString());
                    }
                    hi.setLevel2desc(row.getCell(3).toString());
                }
                hier.add(hi);
                hierID.put(hi.code,hier.size());
                System.out.println(hi.code);

                i++;
                if(floor(i/total*100)>lastpercentage) {
                    lastpercentage = (int) floor(i / total * 100);
                    changed = true;
                }
            }
            System.out.println("Fim " + name);
        }

    }


    public static void leprocedure() throws IOException {

        procedwithEP.put(0,1);
        int joinexam=2;
        double total = 53726;
        int lastpercentage = 0;
        File file = new File("urgency_procedures.xlsx");   //creating a new file instance
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
        //creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        Iterator<Sheet> sheets = wb.iterator();
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        StringBuilder sb = new StringBuilder();
        double i = 0;
        while (sheets.hasNext()) {
            boolean changed = true;
            Sheet sh = sheets.next();
            String name = sh.getSheetName();
            System.out.println("\nFicheiro " + name + "\n");
            itr = sh.rowIterator();
            Row row = itr.next();
            while (itr.hasNext()) {
                row = itr.next();
                if (changed)
                    System.out.println(lastpercentage + "%");
                changed = false;
                boolean nulls = false;

                int epnum = (int) Double.parseDouble(row.getCell(0).toString());
                int data = dates.addData(trataDatas(row.getCell(2).toString()));
                int data2 = dates.addData(trataDatas(row.getCell(4).toString()));
                int pro = (int) Double.parseDouble(row.getCell(1).toString());
                int cod = (int) Double.parseDouble(row.getCell(3).toString());
                int inter = (int) Double.parseDouble(row.getCell(9).toString());

                if(!interventions.containsKey(inter))
                    interventions.put(inter,row.getCell(10).toString());

                int date2=-1;
                if(row.getCell(6)!=null)
                    date2 = dates.addData(trataDatas(row.getCell(6).toString()));

                Procedure pr = new Procedure();

                prof.addProf(row.getCell(1).toString());
                pr.setProf(pro);
                pr.setDate(data);
                pr.setProcedure(cod);
                if(procedwithEP.containsKey(epnum))
                    pr.setJoinid(procedwithEP.get(epnum));
                else
                    pr.setJoinid(joinexam);
                pr.setBegin(data2);
                pr.setIntervention(inter);
                if(row.getCell(5)!=null)
                    pr.setNote(row.getCell(5).toString());

                if(row.getCell(6)!=null)
                    pr.setCanceldate(date2);
                else pr.setIntervention(1);

                if(row.getCell(7)!=null){
                    pro = (int) Double.parseDouble(row.getCell(7).toString());
                    prof.addProf(row.getCell(7).toString());
                    pr.setProfcancel(pro);
                }
                else pr.setProfcancel(1);

                if(row.getCell(8)!=null)
                    pr.setNotecancel(row.getCell(8).toString());

                procedure.add(pr);
                if(!procedwithEP.containsKey(epnum)) {
                    procedwithEP.put(epnum, joinexam);
                    joinexam++;
                }
                i++;
                if(floor(i/total*100)>lastpercentage) {
                    lastpercentage = (int) floor(i / total * 100);
                    changed = true;
                }
            }
            System.out.println("Fim " + name);
        }

    }


    public static void leprescription() throws IOException {
        prescripwithEP.put(0,1);

        int joinexam=2;
        double total = 87491;
        int lastpercentage = 0;
        File file = new File("urgency_prescriptions.xlsx");   //creating a new file instance
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
        //creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        Iterator<Sheet> sheets = wb.iterator();
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        StringBuilder sb = new StringBuilder();
        double i = 0;
        while (sheets.hasNext()) {
            boolean changed = true;
            Sheet sh = sheets.next();
            String name = sh.getSheetName();
            System.out.println("\nFicheiro " + name + "\n");
            itr = sh.rowIterator();
            Row row = itr.next();
            while (itr.hasNext()) {
                row = itr.next();
                if (changed)
                    System.out.println(lastpercentage + "%");
                changed = false;
                boolean nulls = false;

                int epnum = (int) Double.parseDouble(row.getCell(0).toString());
                int data = dates.addData(trataDatas(row.getCell(3).toString()));
                int pro = (int) Double.parseDouble(row.getCell(2).toString());
                int cod = (int) Double.parseDouble(row.getCell(1).toString());
                int coddrug = (int) Double.parseDouble(row.getCell(4).toString());
                int qt = (int) Double.parseDouble(row.getCell(5).toString());
                int pvp = (int) Double.parseDouble(row.getCell(6).toString());
                int comp = (int) Double.parseDouble(row.getCell(7).toString());


                Prescription pr = new Prescription();
                if(row.getCell(9)!=null)
                    pr.setDesc(row.getCell(9).toString());
                pr.setCode(cod);
                prof.addProf(row.getCell(2).toString());
                pr.setProf(pro);
                pr.setDate(data);
                pr.setCode_drug(coddrug);
                if(prescripwithEP.containsKey(epnum))
                    pr.setJoinid(prescripwithEP.get(epnum));
                else
                    pr.setJoinid(joinexam);
                if(row.getCell(8)!=null)
                    pr.setPosology(row.getCell(8).toString());
                prescription.add(pr);
                if(!prescripwithEP.containsKey(epnum)) {
                    prescripwithEP.put(epnum, joinexam);
                    joinexam++;
                }
                i++;
                if(floor(i/total*100)>lastpercentage) {
                    lastpercentage = (int) floor(i / total * 100);
                    changed = true;
                }
            }
            System.out.println("Fim " + name);
        }

    }

    public static void leexames() throws IOException {
        examwithEP.put(0,1);

        int joinexam=1;
        double total = 61694;
        int lastpercentage = 0;
        File file = new File("urgency_exams.xlsx");   //creating a new file instance
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
        //creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        Iterator<Sheet> sheets = wb.iterator();
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        StringBuilder sb = new StringBuilder();
        double i = 0;
        while (sheets.hasNext()) {
            boolean changed = true;
            Sheet sh = sheets.next();
            String name = sh.getSheetName();
            System.out.println("\nFicheiro " + name + "\n");
            itr = sh.rowIterator();
            Row row = itr.next();
            while (itr.hasNext()) {
                row = itr.next();
                if (changed)
                    System.out.println( lastpercentage + "%");
                changed = false;
                boolean nulls = false;

                int epnum = (int) Double.parseDouble(row.getCell(0).toString());
                joinexam=joinexam+1;
                Exam ex = new Exam();
                if(row.getCell(2)!=null)
                    ex.setDesc(row.getCell(2).toString());
                ex.setNum_exam(row.getCell(1).toString());
                if(!examwithEP.containsKey(epnum)) {
                    ex.setJoin(joinexam);
                    exam.add(ex);
                    examwithEP.put(epnum, joinexam);
                }
                else{
                    ex.setJoin(examwithEP.get(epnum));
                    exam.add(ex);
                }
                i++;
                if(floor(i/total*100)>lastpercentage) {
                    lastpercentage = (int) floor(i / total * 100);
                    changed = true;
                }
            }
            System.out.println("Fim " + name);
        }

    }



    public static void leFicheiro() throws IOException{
        Diagnosis diag = new Diagnosis();
        diag.setCode(0);
        diagnosis.add(diag);
        double total = 65618;
        int lastpercentage=0;
        File file = new File("urgency_episodes_new.xlsx");   //creating a new file instance
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
        //creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        Iterator<Sheet> sheets = wb.iterator();
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        StringBuilder sb = new StringBuilder();
        double i = 0;
        while (sheets.hasNext()) {
            int k=0;
            boolean changed=true;
            Sheet sh = sheets.next();
            String name = sh.getSheetName();
            System.out.println("\nFicheiro " + name + "\n");
            itr = sh.rowIterator();
            Row row = itr.next();
            while (itr.hasNext()) {
                row = itr.next();
                if(changed)
                    System.out.println(lastpercentage + "%");
                changed=false;

                int epnum = (int) Double.parseDouble(row.getCell(0).toString());

                Episódio ep= new Episódio();

                ep.setEpisodio(epnum);

                if(examwithEP.containsKey(epnum))
                    ep.setExam(examwithEP.get(epnum));
                else
                    ep.setExam(examwithEP.get(0));

                if(prescripwithEP.containsKey(epnum))
                    ep.setPrescription(prescripwithEP.get(epnum));
                else
                    ep.setPrescription(prescripwithEP.get(0));

                if(procedwithEP.containsKey(epnum))
                    ep.setProcedure(procedwithEP.get(epnum));
                else
                    ep.setProcedure(procedwithEP.get(0));

                ep.setDateofbirth(dates.addData(trataDatas(row.getCell(1).toString())));

                ep.setGender(genders.addgender(row.getCell(2).toString()));

                ep.setDistrict(district.addDistrict(row.getCell(3).toString()));

                /////////////////////////////// ADMITION

                int date = dates.addData(trataDatas(row.getCell(4).toString()));
                int d = (int) Double.parseDouble(row.getCell(5).toString());
                cause.addCause( d, row.getCell(6).toString());

                int p = (int) Double.parseDouble(row.getCell(7).toString());
                prof.addProf(row.getCell(7).toString());


                Admition ad = new Admition();
                ad.setCause(d);
                ad.setDate(date);
                ad.setProf(p);
                admitions.add(ad);

                ep.setProf_admition(admitions.size());

                //////////////////////////////// TRIAGE

                date = dates.addData(trataDatas(row.getCell(8).toString()));

                p = (int) Double.parseDouble(row.getCell(9).toString());
                prof.addProf(row.getCell(9).toString());

                d = (int) Double.parseDouble(row.getCell(11).toString());
                color.addColor( d, row.getCell(12).toString());

                int pain = (int) Double.parseDouble(row.getCell(10).toString());

                Triage tr = new Triage();
                tr.setColor(d);
                tr.setDate(date);
                tr.setPain(pain);
                tr.setProf(p);
                triage.add(tr);

                ep.setTriage(triage.size());

                ///////////////////////////////// DIAGNOSIS

                date = dates.addData(trataDatas(row.getCell(16).toString()));

                p = (int) Double.parseDouble(row.getCell(17).toString());
                prof.addProf(row.getCell(17).toString());
                Diagnosis di = new Diagnosis();
                di.setDate(date);
                di.setProf(p);
                DiagnosisCode dc = new DiagnosisCode();

                dc.setDiagnosis(row.getCell(14).toString());
                if(row.getCell(15) != null)
                    dc.setNote(row.getCell(15).toString());
                try{
                    dc.setCode(String.valueOf(Double.parseDouble(row.getCell(13).toString())));
                }
                catch (Exception e){
                    dc.setCode(row.getCell(13).toString());
                }
                if(hierID.containsKey(dc.getCode()))
                    dc.setHierarchy(hierID.get(dc.getCode()));
                else{dc.setHierarchy(1);}
                diagnosiscode.add(dc);
                di.setCode(diagnosiscode.size());
                diagnosis.add(di);


                ep.setDiagnosis(diagnosis.size());


                //////////////////////////////// DISCHARGE

                int dest = (int) Double.parseDouble(row.getCell(18).toString());
                destination.addDestination( dest, row.getCell(19).toString());

                p = -1;
                if(row.getCell(20) != null) {
                    p = (int) Double.parseDouble(row.getCell(20).toString());
                    prof.addProf(row.getCell(20).toString());
                }

                date= -1;
                if(row.getCell(21) != null)
                    date = dates.addData(trataDatas(row.getCell(21).toString()));

                d = (int) Double.parseDouble(row.getCell(22).toString());
                reason.addReason( d, row.getCell(23).toString());

                Discharge ds = new Discharge();

                if(date!=-1)
                    ds.setDate(date);
                if(p!=-1)
                    ds.setProf(p);
                ds.setReason(d);
                ds.setDestination(dest);

                discharges.add(ds);

                ep.setDischarge(discharges.size());

                episódios.add(ep);

                i++;
                if(floor(i/total*100)>lastpercentage) {
                    lastpercentage = (int) floor(i / total * 100);
                    changed = true;
                }
            }
            System.out.println("Fim do " + name);
        }
    }


    public static void main(String[] args) throws IOException {

        dates.addData("null");
        prof.addProf("null");
        lediagnosis();
        scriptsTabelas.codes(hier);
        hier.clear();

        leexames();
        scriptsTabelas.dim_exams_episode(examwithEP);
        scriptsTabelas.dim_exam(exam);
        exam.clear();

        leprescription();
        scriptsTabelas.dim_prescriptions_episode(prescripwithEP);
        scriptsTabelas.dim_prescription(prescription);
        prescription.clear();

        leprocedure();
        scriptsTabelas.dim_procedures_episode(procedwithEP);
        scriptsTabelas.dim_intervention(interventions);
        interventions.clear();
        scriptsTabelas.dim_procedure(procedure);
        procedure.clear();


        leFicheiro();
        scriptsTabelas.dim_date(dates);
        dates = null;
        scriptsTabelas.dim_prof(prof);
        prof = null;
        scriptsTabelas.dim_color(color);
        scriptsTabelas.dim_reason(reason);
        scriptsTabelas.dim_destination(destination);
        scriptsTabelas.dim_diagnosiscode(diagnosiscode);
        scriptsTabelas.dim_diagnosis(diagnosis);
        scriptsTabelas.dim_district(district);
        scriptsTabelas.dim_gender(genders);
        scriptsTabelas.dim_Admition(admitions);
        scriptsTabelas.dim_triage(triage);
        scriptsTabelas.dim_Discharge(discharges);

        scriptsTabelas.fact_table(episódios);

        System.out.println(error.size());

        FileOutputStream fos = new FileOutputStream(new File("em_falta"));
        String desc;
        for (String e : error) {
            String s = e + "\n";
            fos.write(s.getBytes());
            fos.flush();
        }
        fos.flush();
        fos.close();

        System.out.println("ALL DONE ");


    }
}
