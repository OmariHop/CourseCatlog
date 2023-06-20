package management;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Course {
private String prefix;
private int courseNumber;
private String modality;
private boolean lab;
private HashMap<Integer, Integer> labs;
private String description;

public Course() {
super();
}

public Course(String prefix, int courseNumber, String modality, boolean lab, String description) {
super();
this.prefix = prefix;
this.courseNumber = courseNumber;
this.modality = modality;
this.lab = lab;
this.description = description;
}

public Course(String prefix, int courseNumber, String modality, boolean lab, HashMap<Integer, Integer> labs, String description) {
super();
this.prefix = prefix;
this.courseNumber = courseNumber;
this.modality = modality;
this.lab = lab;
this.labs = labs;
this.description = description;
}

public String getPrefix() {
return prefix;
}

public void setPrefix(String prefix) {
this.prefix = prefix;
}

public int getCourseNumber() {
return courseNumber;
}

public void setCourseNumber(int courseNumber) {
this.courseNumber = courseNumber;
}

public String getModality() {
return modality;
}

public void setModality(String modality) {
this.modality = modality;
}

public boolean isLab() {
return lab;
}

public void setLab(boolean lab) {
this.lab = lab;
}

public HashMap<Integer, Integer> getLabs() {
return labs;
}

public void setLabs(HashMap<Integer, Integer> labs) {
this.labs = labs;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}
}


public class Student {
protected String name;
protected int id;
protected boolean graduate;
protected ArrayList<Course> lecturesTaken;

public Student() {
super();
}

public Student(String name, int id, ArrayList<Course> lecturesTaken) {
super();
this.name = name;
this.id = id;
this.lecturesTaken = lecturesTaken;
}

public Student(String name, int id, boolean graduate, ArrayList<Course> lecturesTaken) {
super();
this.name = name;
this.id = id;
this.graduate = graduate;
this.lecturesTaken = lecturesTaken;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public boolean isGraduate() {
return graduate;
}

public void setGraduate(boolean graduate) {
this.graduate = graduate;
}

public ArrayList<Course> getLecturesTaken() {
return lecturesTaken;
}

public void setLecturesTaken(ArrayList<Course> lecturesTaken) {
this.lecturesTaken = lecturesTaken;
}

public void addLecture(Course course) {
this.lecturesTaken.add(course);
}
}


public class TeachingAssistant extends Student {
private HashMap<Integer, Integer> labsSupervised;
private Faculty advisor;
private String expectedDegree;

public TeachingAssistant() {
super();
}

public TeachingAssistant(HashMap<Integer, Integer> labsSupervised,
String expectedDegree) {
super();
this.labsSupervised = labsSupervised;
this.expectedDegree = expectedDegree;
}

public TeachingAssistant(HashMap<Integer, Integer> labsSupervised, Faculty advisor,
String expectedDegree) {
super();
this.labsSupervised = labsSupervised;
this.advisor = advisor;
this.expectedDegree = expectedDegree;
}

public HashMap<Integer, Integer> getLabsSupervised() {
return labsSupervised;
}

public void setLabsSupervised(HashMap<Integer, Integer> labsSupervised) {
this.labsSupervised = labsSupervised;
}

public Faculty getAdvisor() {
return advisor;
}

public void setAdvisor(Faculty advisor) {
this.advisor = advisor;
}

public String getExpectedDegree() {
return expectedDegree;
}

public void setExpectedDegree(String expectedDegree) {
this.expectedDegree = expectedDegree;
}

public void addLab(Integer lab, Integer ta) {
this.labsSupervised.put(lab, ta);
}
}




public class Faculty {
private String name;
private int id;
private String rank;
private String officeLocation;
private ArrayList<Course> lecturesTaught;

public Faculty() {
super();
}

public Faculty(String name, int id, String rank, String officeLocation, ArrayList<Course> lecturesTaught) {
super();
this.name = name;
this.id = id;
this.rank = rank;
this.officeLocation = officeLocation;
this.lecturesTaught = lecturesTaught;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public String getRank() {
return rank;
}

public void setRank(String rank) {
this.rank = rank;
}

public String getOfficeLocation() {
return officeLocation;
}

public void setOfficeLocation(String officeLocation) {
this.officeLocation = officeLocation;
}

public ArrayList<Course> getLecturesTaught() {
return lecturesTaught;
}

public void setLecturesTaught(ArrayList<Course> lecturesTaught) {
this.lecturesTaught = lecturesTaught;
}
}


public class Main {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

String name, designation;
int id, crn, lectureCount, labCount;

Student student = new Student();
TeachingAssistant teachingAssistant = new TeachingAssistant();
Faculty faculty = new Faculty();

ArrayList<Student> students = new ArrayList<Student>();
ArrayList<TeachingAssistant> teachingAssistants = new ArrayList<TeachingAssistant>();
ArrayList<Faculty> faculties = new ArrayList<Faculty>();

HashMap <Integer, Integer> labs = new HashMap<Integer, Integer>();
labs.put(19745, 1234567);
labs.put(36598, 2589631);
labs.put(20315, 7845129);

ArrayList<Course> coursesOffered = new ArrayList<Course>();
coursesOffered.add(new Course("COT6578", 89745, "F2F", false, "(Advanced Computer theory, Graduate)"));
coursesOffered.add(new Course("COP5698", 69745, "F2F", true, labs, "(Programming Languages, Graduate)"));
coursesOffered.add(new Course("COP3330", 89745, "F2F", false, "(Introduction Object Oriented Programming, Undergraduate)"));

System.out.println("_____List of classes offered at the CSD_____");

for (int i = 0; i < coursesOffered.size(); i++) {
System.out.println("Prefix: " + coursesOffered.get(i).getPrefix());
System.out.println(coursesOffered.get(i).getDescription());
System.out.println("CRN: " + coursesOffered.get(i).getCourseNumber());
System.out.println("Modality: " + coursesOffered.get(i).getModality());

if (coursesOffered.get(i).isLab() == false) {
System.out.println("Lab: No");
}

else {
System.out.println("Lab: Yes (crn of the Lab/id number of the TA");
for (Entry j: labs.entrySet()) {
System.out.println(j.getKey() + "/" + j.getValue());
}
}

System.out.println("---------");
}

while(true) {
System.out.println("____Choose one of the options____");
System.out.println("1. Enter the information of the faculty, the TA or the student");
System.out.println("2. Print schedule");
System.out.println("3. Exit Program");

System.out.println("Enter your selection: ");
int choice = Integer.parseInt(sc.nextLine());

if (choice == 3) {
System.out.println("GoodBye!");
break;
}

switch(choice) {
case 1: System.out.println("Enter name: ");
name = sc.nextLine();

System.out.println("Enter id number: ");
id = Integer.parseInt(sc.nextLine());

System.out.println("Enter F for Faculty, T for TA or S for Student: ");
designation = sc.next();

if (designation.equals("t") || designation.equals("T")) {
teachingAssistant.setName(name);
teachingAssistant.setId(id);

System.out.println("Enter how many Lectures taken by " + name + ": ");
lectureCount = Integer.parseInt(sc.nextLine());

for (int i = 0; i < lectureCount; i++) {
System.out.println("Collecting info of Lecture " + (i + 1) + ": ");
System.out.println("Enter crn: ");
crn = Integer.parseInt(sc.nextLine());

for (int j = 0; j < coursesOffered.size(); j++) {
if (coursesOffered.get(i).getCourseNumber() == crn) {
System.out.println(coursesOffered.get(i).getDescription());
teachingAssistant.addLecture(coursesOffered.get(i));
}
}
}

System.out.println("Now, enter how many Labs, John Smith is supervising: ");
labCount = Integer.parseInt(sc.nextLine());

for (int i = 0; i < labCount; i++) {
System.out.println("Collecting info of Lab " + (i + 1) + ": ");
System.out.println("Enter crn: ");
crn = Integer.parseInt(sc.nextLine());

boolean found = false;

for (Entry j: labs.entrySet()) {
if (j.getKey().toString().equals("" + crn)) {
found = true;
teachingAssistant.addLab(Integer.parseInt(j.getKey().toString()), Integer.parseInt(j.getValue().toString()));
}
}

if (found == false) {
System.out.println("Incorrect crn");
System.out.println("Would you like to re-enter the crn (Yes or No)?");
String c = sc.nextLine();

if (c.equals("yes") || c.equals("Yes")) {
System.out.println("Enter crn: ");
crn = Integer.parseInt(sc.nextLine());

for (Entry j: labs.entrySet()) {
if (j.getKey().toString().equals("" + crn)) {
teachingAssistant.addLab(Integer.parseInt(j.getKey().toString()), Integer.parseInt(j.getValue().toString()));
}
}
}

else {

}
}
}
}

else if (designation.equals("S") || designation.equals("s")) {
student.setName(name);
student.setId(id);

System.out.println("Enter how many Lectures taken by " + name + ":");
lectureCount = Integer.parseInt(sc.nextLine());

for (int i = 0; i < lectureCount; i++) {
System.out.println("Collecting info of Lecture " + (i + 1) + ": ");
System.out.println("Enter crn: ");
crn = Integer.parseInt(sc.nextLine());

for (int j = 0; j < coursesOffered.size(); j++) {
if (coursesOffered.get(i).getCourseNumber() == crn) {
System.out.println(coursesOffered.get(i).getDescription());
student.addLecture(coursesOffered.get(i));
}
}
}
}

break;

case 2: System.out.println("Enter id number: ");
id = Integer.parseInt(sc.nextLine());

if (teachingAssistants.size() == 0) {
System.out.println("ID doesn’t exit");
}

else {
for (int i = 0; i < teachingAssistants.size(); i++) {
HashMap <Integer, Integer> temp = teachingAssistants.get(i).getLabsSupervised();

for (Entry j: temp.entrySet()) {
if (j.getValue().toString().equals("" + id)) {
System.out.println("Record Found: " + teachingAssistants.get(i).getName() + ", TA");
System.out.println("Lectures Taken: ");

for (int k = 0; k < teachingAssistants.get(i).getLecturesTaken().size(); k++) {
System.out.println(teachingAssistants.get(i).getLecturesTaken().get(i).getCourseNumber() + "/" + teachingAssistants.get(i).getLecturesTaken().get(i).getPrefix() + ", ");
}

System.out.println("Labs Supervised: " + j.getKey());
}
}
}
}

break;

default: break;
}
}
}
}