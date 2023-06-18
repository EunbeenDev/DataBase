package com.example.database.controller;

import com.example.database.domain.*;
import com.example.database.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class DatabaseController {

    @Autowired
    StudentService studentService;
    @Autowired
    ProfessorService professorService;
    @Autowired
    CourseService courseService;
    @Autowired
    EnrollService enrollService;
    @Autowired
    LectureService lectureService;
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    StocksService stocksService;
    @Autowired
    AuthorService authorService;
    @Autowired
    WrittenByService writtenByService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    PublishedByService publishedByService;
    @Autowired
    BookService bookService;
    @Autowired
    ContainsService containsService;
    @Autowired
    ShoppingBasketService shoppingBasketService;
    @Autowired
    BasketOfService basketOfService;
    @Autowired
    CustomerService customerService;

    //1.

    //1.a 각 Table에 존재하는 Data를 확인하고 tuple의 총 갯수를 출력할 수 있어야 한다.

    //각 테이블 모두 Service의 findAll() 메소드를 실행하여 Repository를 반환한다.
    // 반환된 Repository에서 각 테이블들의 모든 정보와 tuple 수를 반환하는 쿼리문을 사용하여 각 페이지에서 보여준다.

    //a. show STUDENT
    //StudentService의 findAll()을 실행하고 view는 1_a_Student.jsp이다.
    @GetMapping(value="/1_a_student")
    public ModelAndView stu(){
        ModelAndView modelAndView = new ModelAndView("1_a_Student");

        int cnt=studentService.cnt();
        modelAndView.addObject("cnt",cnt);
        List<StudentEntity> students = studentService.findAll();
        modelAndView.addObject("students",students);

        return modelAndView;
    }


    //a. show PROFESSOR
    //ProfessorService의 findAll()을 실행하고 view는 1_a_Professor.jsp이다.
    @GetMapping(value="/1_a_professor")
    public ModelAndView prof(){
        ModelAndView modelAndView = new ModelAndView("1_a_Professor");

        int cnt=professorService.cnt();
        modelAndView.addObject("cnt",cnt);
        List<ProfessorEntity> professors = professorService.findAll();
        modelAndView.addObject("professors",professors);

        return modelAndView;
    }


    //a. show COURSE
    //CourseService의 findAll()을 실행하고 view는 1_a_Course.jsp이다.
    @GetMapping(value="/1_a_course")
    public ModelAndView cour(){
        ModelAndView modelAndView = new ModelAndView("1_a_Course");

        int cnt=courseService.cnt();
        modelAndView.addObject("cnt",cnt);
        List<CourseEntity> courses = courseService.findAll();
        modelAndView.addObject("courses",courses);

        return modelAndView;
    }


    //a. show ENROLL
    //EnrollService의 findAll()을 실행하고 view는 1_a_Enroll.jsp이다.
    @GetMapping(value="/1_a_enroll")
    public ModelAndView enr(){
        ModelAndView modelAndView = new ModelAndView("1_a_Enroll");

        int cnt=enrollService.cnt();
        modelAndView.addObject("cnt",cnt);
        List<EnrollEntity> enrolls = enrollService.findAll();
        modelAndView.addObject("enrolls",enrolls);

        return modelAndView;
    }


    //a. show LECTURE
    //LectureService의 findAll()을 실행하고 view는 1_a_Lecture.jsp이다.
    @GetMapping(value="/1_a_lecture")
    public ModelAndView lec(){
        ModelAndView modelAndView = new ModelAndView("1_a_Lecture");

        int cnt=lectureService.cnt();
        modelAndView.addObject("cnt",cnt);
        List<LectureEntity> lectures = lectureService.findAll();
        modelAndView.addObject("lectures",lectures);

        return modelAndView;
    }


    //b)특정 Student를 선택하여 해당 Student가 수강하는 Course 이름과 학점 및 시험 점수를 검색할 수 있어야 한다.

    //1_b 페이지에서 모든 학생 이름을 출력한다. 출력된 학생 이름 중 하나를 선택하여 클릭하면,
    // /1_b/{선택한 학생 이름} 페이지로 넘어가 해당 학생에 대한 정보를 보여준다.
    @GetMapping(value="/1_b")
    public  ModelAndView getAllStudents(){
        ModelAndView modelAndView = new ModelAndView("1_b");

        List<Object[]> allStudents = studentService.getAllStudents();
        modelAndView.addObject("allStudents", allStudents);

        return modelAndView;
    }

    @GetMapping(value="/1_b/{studentName}")
    public ModelAndView getStudentInfo(@PathVariable("studentName") String studentName) {
        ModelAndView modelAndView=new ModelAndView("1_b_Info");

        List<Object[]> student = studentService.getStudentByName(studentName);
        modelAndView.addObject("student", student);

        return modelAndView;
    }


    //c)Student의 시험 점수에 대한 학점이 잘못 기재되어 있는 학생의 이름과 학번, 과목번호를 확인 할 수 있어야 하며,
    // 수정 요청에 대해 정상적인 학점으로 수정이 되어야 한다. (단, 학점 부여방식은 다음과 같다고 가정한다.
    // 60점 미만 : F, 60~69 : D, 70~79 : C, 80 ~89 : B, 90 이상 : A)

    // /1_c 페이지에서 학점이 잘못 입력된 학생 목록을 보여준다. 해당 학생들 목록 중 하나를 선택하여 "수정"을 클릭하면,
    // /1_c/{선택한 학생의 학번} 페이지로 넘어가 해당 학생에 대한 학점을 수정하여 보여준다.
    @GetMapping(value="/1_c")
    public ModelAndView weiredGrade(){
        ModelAndView modelAndView=new ModelAndView("1_c");
        List<Object[]> weireds = enrollService.weiredGrade();
        modelAndView.addObject("weireds", weireds);
        return modelAndView;
    }

    @GetMapping(value="/1_c/{studentNumber}")
    public ModelAndView correctGrade(@PathVariable("studentNumber") String studentNumber){
        ModelAndView modelAndView = new ModelAndView("1_c_Correct");
        List<Object[]> correct = enrollService.correctGrade(studentNumber);
        modelAndView.addObject("correct", correct);
        return modelAndView;
    }


    //d)과목별로 최고 점수와, 최저 점수를 획득 한 학생의 정보를 확인 할 수 있어야 한다.
    //EnrollService의 examMaxMin 메소드를 실행하여 과목별 최고점, 최저점에 대한 정보를 얻어낸다.
    //그리고, EnrollService의 examMin, exaMax 메소드를 각각 실행하여
    // examMaxMin에서의 과목명과 점수가 일치하는 학생 정보를 얻어내 /1_d 페이지에 보여준다.
    @GetMapping(value="/1_d")
    public ModelAndView examMaxMin(){
        ModelAndView modelAndView=new ModelAndView("1_d");

        List<Object[]> examMaxMins=enrollService.examMaxMin();
        modelAndView.addObject("examMaxMins",examMaxMins);

        String cno=examMaxMins.get(0)[0].toString();

        List<Object[]> examMins=enrollService.examMin(cno);
        modelAndView.addObject("examMins",examMins);

        List<Object[]> examMaxs=enrollService.examMax(cno);
        modelAndView.addObject("examMaxs",examMaxs);

        return modelAndView;
    }


    //e)학생별로 수강한 교과목의 총학점(sum of credits)과 시험점수의 평균을 확인할 수 있어야 한다.
    //StudentService의 totCour 메소드를 실행하여 StudentRepository의 쿼리문을 실행하여 반환된 결과를 /1_e 페이지에 보여준다.
    @GetMapping(value="/1_e")
    public ModelAndView  totCour(){
        ModelAndView modelAndView=new ModelAndView("1_e");

        List<Object[]> totCours=studentService.totCour();
        modelAndView.addObject("totCours",totCours);

        return modelAndView;
    }


    //f)과목별로 전체 평균 점수와 학점별 학생 수를 확인할 수 있어야 한다.
   //EnrollService의 avgExam 메소드를 실행하여 EnrollRepository의 query에서 과목별 전체 평균이 반환된 결과를 List<Object[]>형태로 /1_f 페이지에 보여준다.
   //EnrollService의 gradeCnt 메소드를 실행하여 EnrollRepository의 query에서 학점별 전체 평균이 반환된 결과를 List<Object[]>형태로 /1_f 페이지에 보여준다.
    @GetMapping(value = "/1_f")
    public ModelAndView avgExam() {
        ModelAndView modelAndView = new ModelAndView("1_f");

        List<Object[]> avgExams = enrollService.avgExam();
        modelAndView.addObject("avgExams", avgExams);

        List<Object[]> gradeCnts = enrollService.gradeCnt(avgExams.get(0)[0].toString());
        modelAndView.addObject("gradeCnts", gradeCnts);

        return modelAndView;
    }


    //g)학과별로 개설된 강좌(Lecture)의 수를 확인 할 수 있어야 한다.
    //CourseService의 DeptCour 메소드를 실행하여 CourseRepository의 학과별로 개설된 강좌 수를 반환하는 쿼리문을 수행하고,
    // 그 결과를 /1_g 페이지에 보여준다.
    @GetMapping(value="/1_g")
    public ModelAndView deptCour(){
        ModelAndView modelAndView=new ModelAndView("1_g");

        List<Object[]> deptCourses=courseService.DeptCour();
        modelAndView.addObject("deptCourses",deptCourses);
        return modelAndView;
    }


    //h)학과별, 학년별 총 학생 수를 확인할 수 있어야 한다.
    // StudentService의 stuCnt 메소드를 실행하고, StudentRepository로 넘어가 학과별, 학년별 총 학생수를 반환하는 쿼리문을 수행하게 된다.
    //그 결과를 1_h 페이지에 보여준다.
    @GetMapping(value="/1_h")
    public ModelAndView stuCnt(){
        ModelAndView modelAndView=new ModelAndView("1_h");

        List<Object[]> stuCnts=studentService.stuCnt();
        modelAndView.addObject("stuCnts",stuCnts);

        return modelAndView;
    }


    //2.

    //a)특정 작가를 선택 하였을 경우 해당 작가가 작성한
    // 도서의 제목, 해당 도서의 재고 수량을 확인할 수 있어야 한다.
    //AuthorServie의 getAllAuthors 메소드를 실행하고, AuthorRepository로 넘어가 모든 작가 정보를 반환하는 쿼리문을 수행한다.
    //그 결과를 /2_a 페이지에 보여준다.
    @GetMapping("/2_a")
    public ModelAndView getAllAuthors() {
        ModelAndView modelAndView = new ModelAndView("2_a");

        List<Object[]> allAuthors = authorService.getAllAuthors();
        modelAndView.addObject("allAuthors", allAuthors);

        return modelAndView;
    }

    //2_a 페이지에 출력된 모든 작가들의 정보에서, 특정 작가의 이름을 클릭하면,
    //선택한 작가의 이름을 AuthorService의 getAuthorByName의 파라미터로 전달하여 실행한다.
    // 거기서 AuthorRepository의 동일 이름의 메소드로 반환되어 파라미터로 전달받은 작가 이름에 대한 도서 제목, 수량을 반환하는 쿼리문을 실행하여
    // 그 결과를 /2_a/{선택한 작가의 이름} 페이지에서 보여준다.
    @GetMapping("/2_a/{authorName}")
    public ModelAndView getAuthorInfo(@PathVariable("authorName") String authorName) {
        ModelAndView modelAndView = new ModelAndView("2_a_Info");

        List<Object[]> author = authorService.getAuthorByName(authorName);
        modelAndView.addObject("author", author);

        return modelAndView;
    }


    //b)모든 출판사의 정보를 확인 할 수 있어야 하며, 특정 출판사를 선택 하였을 경우
    // 해당 출판사에서 출판된 도서의 제목과 가격, 재고량을 확인할 수 있어야 한다.
    // 재고량이 없는 경우에는 해당 도서에 대해서 재고가 없음을 알려주어야 한다.

    // /2_b 페이지에서 PublisherService의 getAllPublishers 메소드를 실행하여 Repository로 넘어가 모든 출판사의 정보를 반환하는 쿼리문의 결과를 보여준다.
    // 출판사 정보 목록에서 특정 출판사의 이름을 클릭하면, PublisherService의 getPublisherByName 메소드에 출판사 이름이 파라미터로 전달되어 실행된다.
    // 그 다음, Repository의 동일 이름의 메소드를 반환하여 전달된 특정 출판사 이름에 대한 출판 도서 제목, 가격, 재고를 반환해주는 쿼리문을 실행한다.
    // 그 결과를 /2_b/{publisherName}에 보여준다.
    @GetMapping(value="/2_b")
    public ModelAndView getAllPublishers() {
        ModelAndView modelAndView = new ModelAndView("2_b");

        List<Object[]> allPublishers = publisherService.getAllPublishers();
        modelAndView.addObject("allPublishers", allPublishers);

        return modelAndView;
    }

    @GetMapping("/2_b/{publisherName}")
    public ModelAndView getPublisherBooks(@PathVariable("publisherName") String publisherName) {
        ModelAndView modelAndView=new ModelAndView("2_b_Info");

        List<Object[]> publisher = publisherService.getPublisherByName(publisherName);
        modelAndView.addObject("publisher", publisher);

        return modelAndView;
    }


    //c)모든 고객의 정보를 확인할 수 있어야 하며 특정 고객을 선택 하였을 경우,
    // 해당 고객이 주문한 도서와 해당 도서의 출판사, 저자의 정보를 출력 할 수 있어야 한다.

    //CutomerService의 getAllCustomer 메소드를 실행하여 Repository에 존재하는 모든 고객의 정보를 반환하는 쿼리문을 실행하여 /2_c 페이지에 보여준다.
    // 출력된 고객 정보에서 특정 고객의 이름을 클릭하면 CustomerService의 getCustomerByName 메소드에 고객 이름을 파라미터로 전달하여 실행한다.
    // 해당 메소드에서 반환된 CustomerRepository의 해당 고객이 주문한 도서의 출판사, 저자 정보를 반환하는 쿼리문을 실행하여 /2_c/{customerName} 페이지에 보여준다.
    @GetMapping(value="/2_c")
    public  ModelAndView getAllCustomers(){
        ModelAndView modelAndView = new ModelAndView("2_c");

        List<Object[]> allCustomers = customerService.getAllCustomers();
        modelAndView.addObject("allCustomers", allCustomers);

        return modelAndView;
    }
    @GetMapping(value="/2_c/{customerName}")
    public ModelAndView getCustomerNameInfos(@PathVariable("customerName") String customerName) {
        ModelAndView modelAndView=new ModelAndView("2_c_Info");

        List<Object[]> customer = customerService.getCustomerByName(customerName);
        modelAndView.addObject("customer", customer);

        return modelAndView;
    }


    //d)새로운 도서가 등록 될 경우에는 저자와 출판사 창고별 재고량이 함께 등록 되어야 한다.

    // /2_d/Form 페이지에서 도서, 출판사, 저자, 재고에 대한 정보를 추가하기 위해 필요한 정보를 입력받아,
    // 각 Entity에 대해 save 메소드를 실행하여 insert 쿼리문을 수행한다.
    // 만약 PK, FK constraint에 위반되는 정보가 입력되면, 2_d 페이지에서 경고메세지 출력과 함께 insert 수행을 rollback하도록 한다.
    @GetMapping(value = "/2_d/form")
    public ModelAndView FormBook(){
        ModelAndView modelAndView=new ModelAndView("2_d_Form");
        return modelAndView;
    }
    @PostMapping(value = "/2_d")
    public ModelAndView insertBook(
            BookEntity bookEntity,
            AuthorEntity authorEntity,
            WrittenByEntity writtenByEntity,
            StocksEntity stocksEntity,
            PublishedByEntity publishedByEntity
    ) {
        ModelAndView modelAndView = new ModelAndView("2_d");

        try {
            BookEntity savedBookEntity = bookService.save(bookEntity);
            AuthorEntity savedAuthorEntity = authorService.save(authorEntity);
            WrittenByEntity savedWrittenByEntity = writtenByService.save(writtenByEntity);
            StocksEntity savedStocksEntity = stocksService.save(stocksEntity);
            PublishedByEntity savedPublishedByEntity = publishedByService.save(publishedByEntity);

            modelAndView.addObject("book", savedBookEntity);
            modelAndView.addObject("author", savedAuthorEntity);
            modelAndView.addObject("writtenBy", savedWrittenByEntity);
            modelAndView.addObject("stocks", savedStocksEntity);
            modelAndView.addObject("publishedBy", savedPublishedByEntity);
        } catch (DataIntegrityViolationException e) {
            modelAndView.addObject("error", "입력값을 다시 확인해주세요.");
        }

        return modelAndView;
    }


    //e)전체 도서의 평균 가격 및 년도별 평균 가격을 산정할 수 있어야 한다.

    //BookService의 totBookPrice 메소드를 수행하여 전체 도서의 평균 가격을 반환하는 쿼리문을 수행해 /2_e 페이지에 보여준다.
    //BookSErvice의 yearBookPrices 메소드를 수행하여 연도별 도서들의 평균 가격을 반환하는 쿼리문을 수행하여 동일 페이지에 보여준다.
    @GetMapping(value="/2_e")
    public ModelAndView bookInfo(){
        ModelAndView modelAndView=new ModelAndView("2_e");

        List<Object[]> totBookPrices=bookService.totBookPrice();
        modelAndView.addObject("totBookPrices",totBookPrices);

        List<Object[]> yearBookPrices=bookService.yearBookPrice();
        modelAndView.addObject("yearBookPrices",yearBookPrices);

        return modelAndView;
    }


    //f)작가별 도서의 총 개수, 최고, 최저, 평균 가격을 확인 할 수 있어야 한다.

    //AuthorService의 AuthInfo 메소드를 실행하여
    // AuthorRepository의 작가별 도서의 총 개수, 최고, 최저, 평균 가격을 반환하는 쿼리문을 수행하여
    // /2_f 페이지에 보여준다.
    @GetMapping(value="/2_f")
    public ModelAndView authInfo(){
        ModelAndView modelAndView=new ModelAndView("2_f");

        List<Object[]> authInfos=authorService.authInfo();
        modelAndView.addObject("authInfos",authInfos);

        return modelAndView;
    }


    //g)재고가 특정 부수 이상 넘어가는 도서를 검색하고, 가격 할인을 할 수 있어야 한다.
    // (예, 재고가 500부 이상 남은 도서에 대해서 가격을 10% 할인하여 BOOK.price에 반영)

    // /2_g/Form 페이지에서 부수와 할인율(%)을 입력받는다.
    // 입력받은 부수와 할인율을 BookService의 applySale의 파라미터로 전달하여 할인된 가격을 book 테이블의 price에 적용하는 쿼리문을 수행한다.
    // 그 다음, BookService의 getAppliedBooks 메소드에 입력받았던 부수를 파라미터로 전달하여 가격 할인이 적용된 책들의 가격 정보를 /2_g 페이지에서 확인할 수 있다.
    @GetMapping(value = "/2_g/Form")
    public ModelAndView saleForm() {
        ModelAndView modelAndView = new ModelAndView("2_g_Form");
        modelAndView.addObject("quantity", 0);
        modelAndView.addObject("saleRatio", 0);
        return modelAndView;
    }

    @PostMapping(value = "/2_g")
    public ModelAndView applySale(@RequestParam("quantity") int quantity,
                                  @RequestParam("saleRatio") float saleRatio) {

        bookService.applySale(quantity, saleRatio);
        List<Object[]> saledBooks = bookService.getAppliedBooks(quantity);
        ModelAndView modelAndView = new ModelAndView("2_g");
        modelAndView.addObject("saledBooks", saledBooks);
        return modelAndView;
    }

}

