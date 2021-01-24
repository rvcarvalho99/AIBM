import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class scriptsTabelas {



    public static void dim_date(Dates date) {

        Map<Integer,String> datas = date.getDatas();

        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento2.sql"));

            for (Integer i : datas.keySet()) {
                String query;
                if(i!=1)
                    query = "insert into dim_date values (" + i + ", \"" + datas.get(i) + "\");\n";
                else
                    query = "insert into dim_date values (" + i + ", " + datas.get(i) + ");\n";
                fos.write(query.getBytes());
                fos.flush();
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_color(Color date) {

        Map<Integer,String> datas = date.getColors();

        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento2.sql"),true);

            for (Integer i : datas.keySet()) {

                String query = "insert into dim_color values (" + i + ", \"" + datas.get(i) + "\");\n";
                fos.write(query.getBytes());
                fos.flush();
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_destination(Destination date) {

        Map<Integer,String> datas = date.getDestinations();

        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento2.sql"),true);

            for (Integer i : datas.keySet()) {

                String query = "insert into dim_destination values (" + i + ", \"" + datas.get(i) + "\");\n";
                fos.write(query.getBytes());
                fos.flush();
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_district(District date) {

        Map<Integer,String> datas = date.getDistricts();

        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento4.sql"),true);

            for (Integer i : datas.keySet()) {

                String query = "insert into dim_district values (" + i + ", \"" + datas.get(i) + "\");\n";
                fos.write(query.getBytes());
                fos.flush();
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_reason(Reason date) {

        Map<Integer,String> datas = date.getReasons();

        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento2.sql"),true);

            for (Integer i : datas.keySet()) {

                String query = "insert into dim_reason values (" + i + ", \"" + datas.get(i) + "\");\n";
                fos.write(query.getBytes());
                fos.flush();
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_gender(Genders date) {

        Map<Integer,String> datas = date.getgenders();

        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento4.sql"),true);

            for (Integer i : datas.keySet()) {

                String query = "insert into dim_gender values (" + i + ", \"" + datas.get(i) + "\");\n";
                fos.write(query.getBytes());
                fos.flush();
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_exam(List<Exam> exams) {


        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento1.sql"),true);
            int i=1;
            for (Exam e : exams) {

                String query = "insert into dim_exam values (" + i + ", \"" + e.getDesc() + "\", \"" + e.getNum_exam()+"\", " + e.getJoin()+");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_prof(Prof exams) {


        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento2.sql"),true);
            int i=1;
            for (String e : exams.getProfs()) {
                String query;
            if(!e.equals("1"))
                query = "insert into dim_prof values (" + e  +",null);\n";
            else
                query = "insert into dim_prof values (" + e  +",\"NA\");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_exams_episode(Map<Integer,Integer> map) {
        if(map.values().contains(3))
            System.out.println("\n\n\n\n\n\n\n\n\n\n0jayhsgdiashdaios\n\n\n\n\n\n\n\n");


        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento1.sql"),true);
            int i=1;
            for (Integer e : map.values()) {

                String query = "insert into dim_exams_join values (" + e + ");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void dim_prescriptions_episode(Map<Integer,Integer> map) {


        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento1.sql"),true);
            int i=1;
            for (Integer e : map.values()) {

                String query = "insert into dim_prescriptions_episode values (" + e + ");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_procedures_episode(Map<Integer,Integer> map) {

        Collection<Integer> m = map.values();

        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento3.sql"),true);
            int i=1;
            for (Integer e : m) {

                String query = "insert into dim_procedures_episode values (" + e + ");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_intervention(Map<Integer,String> map) {



        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento3.sql"),true);
            int i=1;
            for (Integer e : map.keySet()) {

                String query = "insert into dim_intervention values (" + e + ",\"" + map.get(e) +"\");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_cause(Map<Integer,String> map) {



        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento3.sql"),true);
            int i=1;
            for (Integer e : map.keySet()) {

                String query = "insert into dim_desc_external_cause values (" + e + ",\"" + map.get(e) +"\");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void dim_prescription(List<Prescription> pr) {



        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento3.sql"));
            int i=1;
            String desc;
            for (Prescription e : pr) {
                if(e.getDesc()==null)
                    desc = "";
                else desc= e.getDesc();
                String query = "insert into dim_prescription values (" + i + ", " + e.getCode_drug() + ", \"" +e.getQt() + "\", \"" + e.getPvp() + "\", \"" + e.getCompart() + "\", \"" + e.getPosology() + "\", \"" + desc + "\"," + e.getDate() +"," + e.getCode()+ "," + e.getProf()+ "," + e.getJoinid() + ");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_procedure(List<Procedure> pr) {



        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento3.sql"),true);
            int i=1;
            String note,datecancel, notecancel, profcancel;
            for (Procedure e : pr) {
                if(e.getNote()==null)
                    note = "";
                else note = e.getNote();

                if(e.getNotecancel()==null)
                    notecancel = "";
                else notecancel = e.getNotecancel();

                if(e.getCanceldate()==-1)
                    datecancel = "null";
                else datecancel = String.valueOf(e.getCanceldate());

                if(e.getProfcancel()==-1)
                    profcancel = "null";
                else profcancel = String.valueOf(e.getProfcancel());

                String query = "insert into dim_procedures values (" + i + ", " + e.getProf() + ", " +e.getDate() + ",  " + e.getBegin() + " , \"" + note + "\", " + datecancel + ", \"" + notecancel + "\"," + profcancel +"," + e.getIntervention()+ "," + e.getProcedure()+"," + e.getJoinid() + ");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void dim_Admition(List<Admition> pr) {



        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento4.sql"),true);
            int i=1;
            String desc;
            for (Admition e : pr) {
                String query = "insert into dim_admition values (" + i + ", " + e.getDate() + "," +e.getCause() + ", " + e.getProf() + ");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_Discharge(List<Discharge> pr) {



        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento5.sql"),true);
            int i=1;
            String desc;
            for (Discharge e : pr) {
                String query = "insert into dim_discharge values (" + i + ", " + e.getDate() + "," +e.getReason() + ", " + e.getDestination() + "," + e.getProf() + ");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_triage(List<Triage> pr) {



        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento5.sql"));
            int i=1;
            String desc;
            for (Triage e : pr) {
                String query = "insert into dim_triage values (" + i + ", " + e.getDate() + "," +e.getColor() + ", " + e.getPain() + "," + e.getProf() + ");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_diagnosiscode(List<DiagnosisCode> pr) {



        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento4.sql"));
            int i=1;
            String desc;
            for (DiagnosisCode e : pr) {
                String query = "insert into dim_diagnosis_code values (" + i + ", \"" + e.getDiagnosis() + "\",\"" +e.getNote() + "\", \"" + e.getCode() + "\"," + e.getHierarchy() +" );\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dim_diagnosis(List<Diagnosis> pr) {



        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento4.sql"),true);
            int i=1;
            String desc;
            for (Diagnosis e : pr) {
                String query = "insert into dim_diagnosis values (" + i + ", " + e.getDate() + "," +e.getCode() + ", " + e.getProf() + ");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void codes(List<Hierarchy> pr) {



        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento1.sql"));
            int i=1;
            String exam,procedure,prescription;
            for (Hierarchy e : pr) {

                String query = "insert into dim_hierarchy values (" + i + ", \"" + e.getCode() + "\", \"" +e.getLevel1desc() + "\", \"" +e.getLevel2desc() + "\", \"" + e.getLevel3desc() + "\",\"" + e.getLevel4desc() + "\",\""+ e.getLevel5desc()+"\");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fact_table(List<Episódio> pr) {



        try {
            FileOutputStream fos = new FileOutputStream(new File("povoamento6.sql"));
            int i=1;
            String exam,procedure,prescription;
            for (Episódio e : pr) {
                if(e.getExam()==-1)
                    exam="null";
                else exam = String.valueOf(e.getExam());

                if(e.getPrescription()==-1)
                    prescription="null";
                else prescription = String.valueOf(e.getPrescription());

                if(e.getProcedure()==-1)
                    procedure="null";
                else procedure = String.valueOf(e.getProcedure());
                String query = "insert into fact_table values (" + e.getEpisodio() + ", " + e.getDateofbirth() + "," +e.getGender() + ", " + e.getDistrict() + "," + e.getProf_admition() + ","+ e.getTriage()+"," + e.getDischarge()+"," + e.getDiagnosis()+ "," + exam +"," + procedure+"," + prescription+ ");\n";
                fos.write(query.getBytes());
                fos.flush();
                i++;
            }

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
