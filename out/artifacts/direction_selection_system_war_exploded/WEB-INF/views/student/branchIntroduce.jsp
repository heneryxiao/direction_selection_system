<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Simple landing page</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="../ui/vendors/owl-carousel/css/owl.carousel.min.css">
  <link rel="stylesheet" href="../ui/vendors/owl-carousel/css/owl.theme.default.css">
  <link rel="stylesheet" href="../ui/vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="../ui/vendors/aos/css/aos.css">
  <link rel="stylesheet" href="../ui/css/style.min.css">
</head>
<body id="body" data-spy="scroll" data-target=".navbar" data-offset="100">
  <header id="header-section">
    <nav class="navbar navbar-expand-lg pl-3 pl-sm-0" id="navbar">
    <div class="container">
      <div class="navbar-brand-wrapper d-flex w-100">
        <img src="../ui/images/Group2.svg" alt="">
        <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="mdi mdi-menu navbar-toggler-icon"></span>
        </button> 
      </div>
      <div class="collapse navbar-collapse navbar-menu-wrapper" id="navbarSupportedContent">
        <ul class="navbar-nav align-items-lg-center align-items-start ml-auto">
          <li class="d-flex align-items-center justify-content-between pl-4 pl-lg-0">
            <div class="navbar-collapse-logo">
              <img src="../ui/images/Group2.svg" alt="">
            </div>
            <button class="navbar-toggler close-button" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="mdi mdi-close navbar-toggler-icon pl-5"></span>
            </button>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#header-section" style="width: 100px">首页 <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#features-section" style="width: 100px">方向选择</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#digital-marketing-section" style="width: 100px">详情介绍</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#feedback-section" style="width: 100px">老师介绍</a>
          </li>
          <li class="nav-item btn-contact-us pl-4 pl-lg-0">
            <button class="btn btn-info" data-toggle="modal" data-target="#exampleModal">前往选课</button>
          </li>
        </ul>
      </div>
    </div> 
    </nav>   
  </header>
  <div class="banner" >
    <div class="container">
      <h1 class="font-weight-semibold">软件工程专业共有<br>四个方向选择</h1>
      <h6 class="font-weight-normal text-muted pb-3">根据自己的兴趣爱好，选择一个最合适你的专业方向吧！</h6>
      <div>
        <button class="btn btn-opacity-light mr-1">前往选择</button>
        <button class="btn btn-opacity-success ml-1">了解更多</button>
      </div>
      <img src="../ui/images/Group171.svg" alt="" class="img-fluid">
    </div>
  </div>
  <div class="content-wrapper">
    <div class="container">
      <section class="case-studies" id="case-studies-section">
        <div class="row grid-margin">
          <div class="col-12 text-center pb-5">
            <h2>四大专业方向</h2>
            <h6 class="section-subtitle text-muted">只要勤学苦练，在任何领域都能发光发亮</h6>
          </div>
          <div class="col-12 col-md-6 col-lg-3 stretch-card mb-3 mb-lg-0" data-aos="zoom-in">
            <div class="card color-cards">
              <div class="card-body p-0">
                <div class="bg-primary text-center card-contents">
                  <div class="card-image">
                    <img src="../ui/images/Group95.svg" class="case-studies-card-img" alt="">
                  </div>
                  <div class="card-desc-box d-flex align-items-center justify-content-around">
                    <div>
                      <h6 class="text-white pb-2 px-3">主修：移动平台开发技术、移动互联网、移动终端跨平台等</h6>
                      <button class="btn btn-white">更多课程信息</button>
                    </div>
                  </div>
                </div>
                <div class="card-details text-center pt-4">
                  <h6 class="m-0 pb-1">移动开发</h6>
                  <p>移动开发也称为手机开发，或叫做移动互联网开发。是指以手机、PDA、UMPC等便携终端为基础，进行相应的开发工作，由于这些随身设备基本都采用无线上网的方式，因此，业内也称作为无线开发。</p>
                </div>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-6 col-lg-3 stretch-card mb-3 mb-lg-0" data-aos="zoom-in" data-aos-delay="200">
            <div class="card color-cards">
              <div class="card-body p-0">
                <div class="bg-warning text-center card-contents">
                  <div class="card-image">
                    <img src="../ui/images/Group108.svg" class="case-studies-card-img" alt="">
                  </div>
                  <div class="card-desc-box d-flex align-items-center justify-content-around">
                    <div>
                      <h6 class="text-white pb-2 px-3">主修：功能测试、性能测试、测试管理等</h6>
                      <button class="btn btn-white">更多课程信息</button>
                    </div>
                  </div>
                </div>
                <div class="card-details text-center pt-4">
                  <h6 class="m-0 pb-1">软件测试</h6>
                  <p>软件测试描述一种用来促进鉴定软件的正确性、完整性、安全性和质量的过程。换句话说，软件测试是一种实际输出与预期输出之间的审核或者比较过程。</p>
                </div>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-6 col-lg-3 stretch-card mb-3 mb-lg-0" data-aos="zoom-in" data-aos-delay="400">
            <div class="card color-cards">
              <div class="card-body p-0">
                <div class="bg-violet text-center card-contents">
                  <div class="card-image">
                    <img src="../ui/images/Group126.svg" class="case-studies-card-img" alt="">
                  </div>
                  <div class="card-desc-box d-flex align-items-center justify-content-around">
                    <div>
                      <h6 class="text-white pb-2 px-3">主修：计算机动画、游戏程序设计综合实践、机器学习等</h6>
                      <button class="btn btn-white">更多课程信息</button>
                    </div>
                  </div>
                </div>
                <div class="card-details text-center pt-4">
                  <h6 class="m-0 pb-1">游戏开发</h6>
                  <p>游戏开发指利用计算机编程语言，如C编程语言、C++、java等，编写计算机、手机或游戏机上的游戏。目前流行的游戏编程语言为C++编程语言，游戏编程接口为DirectX9.0、OpenGL和SDL(Simple DirectMedia Layer)等。</p>
                </div>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-6 col-lg-3 stretch-card" data-aos="zoom-in" data-aos-delay="600">
            <div class="card color-cards">
              <div class="card-body p-0">
                <div class="bg-success text-center card-contents">
                  <div class="card-image">
                    <img src="../ui/images/Group115.svg" class="case-studies-card-img" alt="">
                  </div>
                  <div class="card-desc-box d-flex align-items-center justify-content-around">
                    <div>
                      <h6 class="text-white pb-2 px-3">主修：大数据处理程序语言、大数据处理技术、Linux程序设计基础等</h6>
                      <button class="btn btn-white">更多课程信息</button>
                    </div>
                  </div>
                </div>
                <div class="card-details text-center pt-4">
                  <h6 class="m-0 pb-1">大数据</h6>
                  <p>是指无法在一定时间范围内用常规软件工具进行捕捉、管理和处理的数据集合，是需要新处理模式才能具有更强的决策力、洞察发现力和流程优化能力的海量、高增长率和多样化的信息资产。</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section class="features-overview" id="features-section" >
        <div class="content-header">
          <h2>怎么去选择？</h2>
          <h6 class="section-subtitle text-muted">专业方向的选择将决定未来在某一领域的深入学习<br>以及未来职业规划道路</h6>
        </div>
        <div class="d-md-flex justify-content-between">
          <div class="grid-margin d-flex justify-content-start">
            <div class="features-width">
              <img src="../ui/images/Group5.svg" alt="" class="img-icons">
              <h5 class="py-3">明确<br>自身兴趣</h5>
              <p class="text-muted">预先了解一下将要学习的课程，喜欢是建立在了解基础上的，不是说非常理解，这个是几乎做不到的，但是你要有个起码的认知，如果了解了还有兴趣那就是真正的兴趣。</p>
            </div>
          </div>
          <div class="grid-margin d-flex justify-content-center">
            <div class="features-width">
              <img src="../ui/images/Group12.svg" alt="" class="img-icons">
              <h5 class="py-3">了解<br>职位空缺</h5>
              <p class="text-muted">每一个方向领域都会成就不同的职位，职位的空缺率会影响未来就业的成功率，职业空缺也与当前方向领域的火爆程度与难易程度有着不可估量的关系。</p>
            </div>
          </div>
          <div class="grid-margin d-flex justify-content-end">
            <div class="features-width">
              <img src="../ui/images/Group7.svg" alt="" class="img-icons">
              <h5 class="py-3">观察<br>未来趋势</h5>
              <p class="text-muted">每个方向都有自己未来的命运，发展的快慢与当前时代接纳程度息息相关，当一项技术得以突破或某一项产品被广泛大众接受，都会为这一方向提供更多的资源。</p>
            </div>
          </div>

        </div>
      </section>  
      <div class="tlinks">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>   
      <section class="digital-marketing-service" id="digital-marketing-section">
        <div class="row align-items-center">
          <div class="col-12 col-lg-7 grid-margin grid-margin-lg-0" data-aos="fade-right">
            <h3 class="m-0">我们将会发布<br>优秀的学长学姐分享自己的学习经历</h3>
            <div class="col-lg-7 col-xl-6 p-0">
              <p class="py-4 m-0 text-muted">你可以通过观察他们的经历去认识他们所选方向转化为自己的考虑筹码。</p>
              <p class="font-weight-medium text-muted">优秀的人总有优秀的道理，我们不妨借鉴一下，综合考量自己的未来。</p>
            </div>    
          </div>
          <div class="col-12 col-lg-5 p-0 img-digital grid-margin grid-margin-lg-0" data-aos="fade-left">
            <img src="../ui/images/Group1.png" alt="" class="img-fluid">
          </div>
        </div>
        <div class="row align-items-center">
          <div class="col-12 col-lg-7 text-center flex-item grid-margin" data-aos="fade-right">
            <img src="../ui/images/Group2.png" alt="" class="img-fluid">
          </div>
          <div class="col-12 col-lg-5 flex-item grid-margin" data-aos="fade-left">
            <h3 class="m-0">最新行业信息<br>即将上线</h3>
            <div class="col-lg-9 col-xl-8 p-0">
              <p class="py-4 m-0 text-muted">摘选行业内各大巨头针对方向领域的分析报道、各职位的就业信息行情等众多新闻。</p>
              <p class="pb-2 font-weight-medium text-muted">了解最新的行业动态，为自己的未来铺路，抓住机会，搭上时代快车。</p>
            </div>
<%--            <button class="btn btn-info">Readmore</button>--%>
          </div>
        </div>
      </section>     

      <section class="customer-feedback" id="feedback-section">
        <div class="row">
          <div class="col-12 text-center pb-5">
            <h2>师资力量</h2>
            <h6 class="section-subtitle text-muted m-0">一览我校的名师风采</h6>
          </div>
          <div class="owl-carousel owl-theme grid-margin">
              <div class="card customer-cards">
                <div class="card-body">
                  <div class="text-center">
                    <img src="../ui/images/face1.jpg" width="89" height="89" alt="" class="img-customer">
                    <p class="m-0 py-3 text-muted">这是一个教师简介！！！！！！！！！！！！！！！！！！！这是一个教师简介！！！！！！！！！！！！！！！！！！！</p>
                    <div class="content-divider m-auto"></div>
                    <h6 class="card-title pt-3">张三</h6>
                    <h6 class="customer-designation text-muted m-0">博士、教授</h6>
                  </div>
                </div>
              </div>
              <div class="card customer-cards">
                <div class="card-body">
                  <div class="text-center">
                    <img src="../ui/images/face2.jpg" width="89" height="89" alt="" class="img-customer">
                    <p class="m-0 py-3 text-muted">这是一个教师简介！！！！！！！！！！！！！！！！！！！这是一个教师简介！！！！！！！！！！！！！！！！！！！</p>
                    <div class="content-divider m-auto"></div>
                    <h6 class="card-title pt-3">赵一</h6>
                    <h6 class="customer-designation text-muted m-0">博士、副教授</h6>
                  </div>
                </div>
              </div>
              <div class="card customer-cards">
                <div class="card-body">
                  <div class="text-center">
                    <img src="../ui/images/face3.jpg" width="89" height="89" alt="" class="img-customer">
                    <p class="m-0 py-3 text-muted">这是一个教师简介！！！！！！！！！！！！！！！！！！！这是一个教师简介！！！！！！！！！！！！！！！！！！！</p>
                    <div class="content-divider m-auto"></div>
                    <h6 class="card-title pt-3">赵二</h6>
                    <h6 class="customer-designation text-muted m-0">博士、副教授</h6>
                  </div>
                </div>
              </div>
              <div class="card customer-cards">
                <div class="card-body">
                  <div class="text-center">
                    <img src="../ui/images/face8.jpg" width="89" height="89" alt="" class="img-customer">
                    <p class="m-0 py-3 text-muted">这是一个教师简介！！！！！！！！！！！！！！！！！！！这是一个教师简介！！！！！！！！！！！！！！！！！！！</p>
                    <div class="content-divider m-auto"></div>
                    <h6 class="card-title pt-3">赵三</h6>
                    <h6 class="customer-designation text-muted m-0">博士、副教授</h6>
                  </div>
                </div>
              </div>
              <div class="card customer-cards">
                <div class="card-body">
                  <div class="text-center">
                    <img src="../ui/images/face15.jpg" width="89" height="89" alt="" class="img-customer">
                    <p class="m-0 py-3 text-muted">这是一个教师简介！！！！！！！！！！！！！！！！！！！这是一个教师简介！！！！！！！！！！！！！！！！！！！</p>
                    <div class="content-divider m-auto"></div>
                    <h6 class="card-title pt-3">赵四</h6>
                    <h6 class="customer-designation text-muted m-0">博士、副教授</h6>
                  </div>
                </div>
              </div>
              <div class="card customer-cards">
                <div class="card-body">
                  <div class="text-center">
                    <img src="../ui/images/face20.jpg" width="89" height="89" alt="" class="img-customer">
                    <p class="m-0 py-3 text-muted">这是一个教师简介！！！！！！！！！！！！！！！！！！！这是一个教师简介！！！！！！！！！！！！！！！！！！！</p>
                    <div class="content-divider m-auto"></div>
                    <h6 class="card-title pt-3">赵五</h6>
                    <h6 class="customer-designation text-muted m-0">博士、副教授</h6>
                  </div>
                </div>
              </div>
              <div class="card customer-cards">
                <div class="card-body">
                  <div class="text-center">
                    <img src="../ui/images/face2.jpg" width="89" height="89" alt="" class="img-customer">
                    <p class="m-0 py-3 text-muted">这是一个教师简介！！！！！！！！！！！！！！！！！！！这是一个教师简介！！！！！！！！！！！！！！！！！！！</p>
                    <div class="content-divider m-auto"></div>
                    <h6 class="card-title pt-3">赵六</h6>
                    <h6 class="customer-designation text-muted m-0">博士、副教授</h6>
                  </div>
                </div>
              </div>
              <div class="card customer-cards">
                <div class="card-body">
                  <div class="text-center">
                    <img src="../ui/images/face3.jpg" width="89" height="89" alt="" class="img-customer">
                    <p class="m-0 py-3 text-muted">这是一个教师简介！！！！！！！！！！！！！！！！！！！这是一个教师简介！！！！！！！！！！！！！！！！！！！</p>
                    <div class="content-divider m-auto"></div>
                    <h6 class="card-title pt-3">赵七</h6>
                    <h6 class="customer-designation text-muted m-0">博士、副教授</h6>
                  </div>
                </div>
              </div>
              <div class="card customer-cards">
                <div class="card-body">
                  <div class="text-center">
                    <img src="../ui/images/face20.jpg" width="89" height="89" alt="" class="img-customer">
                    <p class="m-0 py-3 text-muted">这是一个教师简介！！！！！！！！！！！！！！！！！！！这是一个教师简介！！！！！！！！！！！！！！！！！！！</p>
                    <div class="content-divider m-auto"></div>
                    <h6 class="card-title pt-3">赵八</h6>
                    <h6 class="customer-designation text-muted m-0">博士、副教授</h6>
                  </div>
                </div>
              </div>
          </div>
        </div>
      </section>
<%--      <section class="contact-us" id="contact-section">--%>
<%--        <div class="contact-us-bgimage grid-margin" >--%>
<%--          <div class="pb-4">--%>
<%--            <h4 class="px-3 px-md-0 m-0" data-aos="fade-down">Do you have any projects?</h4>--%>
<%--            <h4 class="pt-1" data-aos="fade-down">Contact us</h4>--%>
<%--          </div>--%>
<%--          <div data-aos="fade-up">--%>
<%--            <button class="btn btn-rounded btn-outline-danger">Contact us</button>--%>
<%--          </div>          --%>
<%--        </div>--%>
<%--      </section>--%>
<%--      <section class="contact-details" id="contact-details-section">--%>
<%--        <div class="row text-center text-md-left">--%>
<%--          <div class="col-12 col-md-6 col-lg-3 grid-margin">--%>
<%--            <img src="../ui/images/Group2.svg" alt="" class="pb-2">--%>
<%--            <div class="pt-2">--%>
<%--              <p class="text-muted m-0">mikayla_beer@feil.name</p>--%>
<%--              <p class="text-muted m-0">906-179-8309</p>--%>
<%--            </div>         --%>
<%--          </div>--%>
<%--          <div class="col-12 col-md-6 col-lg-3 grid-margin">--%>
<%--            <h5 class="pb-2">Get in Touch</h5>--%>
<%--            <p class="text-muted">Don’t miss any updates of our new templates and extensions.!</p>--%>
<%--            <form>--%>
<%--              <input type="text" class="form-control" id="Email" placeholder="Email id">--%>
<%--            </form>--%>
<%--            <div class="pt-3">--%>
<%--              <button class="btn btn-dark">Subscribe</button>--%>
<%--            </div>   --%>
<%--          </div>--%>
<%--          <div class="col-12 col-md-6 col-lg-3 grid-margin">--%>
<%--            <h5 class="pb-2">Our Guidelines</h5>--%>
<%--            <a href="#"><p class="m-0 pb-2">Terms</p></a>   --%>
<%--            <a href="#" ><p class="m-0 pt-1 pb-2">Privacy policy</p></a> --%>
<%--            <a href="#"><p class="m-0 pt-1 pb-2">Cookie Policy</p></a> --%>
<%--            <a href="#"><p class="m-0 pt-1">Discover</p></a> --%>
<%--          </div>--%>
<%--          <div class="col-12 col-md-6 col-lg-3 grid-margin">--%>
<%--              <h5 class="pb-2">Our address</h5>--%>
<%--              <p class="text-muted">518 Schmeler Neck<br>Bartlett. Illinois</p>--%>
<%--              <div class="d-flex justify-content-center justify-content-md-start">--%>
<%--                <a href="#"><span class="mdi mdi-facebook"></span></a>--%>
<%--                <a href="#"><span class="mdi mdi-twitter"></span></a>--%>
<%--                <a href="#"><span class="mdi mdi-instagram"></span></a>--%>
<%--                <a href="#"><span class="mdi mdi-linkedin"></span></a>--%>
<%--              </div>--%>
<%--          </div>--%>
<%--        </div>  --%>
<%--      </section>--%>
<%--      <footer class="border-top">--%>
<%--        <p class="text-center text-muted pt-4">Copyright © 2019 All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>--%>
<%--      </footer>--%>
<%--      <!-- Modal for Contact - us Button -->--%>
<%--      <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--        <div class="modal-dialog" role="document">--%>
<%--          <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--              <h4 class="modal-title" id="exampleModalLabel">Contact Us</h4>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--              <form>--%>
<%--                <div class="form-group">--%>
<%--                  <label for="Name">Name</label>--%>
<%--                  <input type="text" class="form-control" id="Name" placeholder="Name">--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                  <label for="Email">Email</label>--%>
<%--                  <input type="email" class="form-control" id="Email-1" placeholder="Email">--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                  <label for="Message">Message</label>--%>

  <script src="../ui/vendors/jquery/jquery.min.js"></script>
  <script src="../ui/vendors/bootstrap/bootstrap.min.js"></script>
  <script src="../ui/vendors/owl-carousel/js/owl.carousel.min.js"></script>
  <script src="../ui/vendors/aos/js/aos.js"></script>
  <script src="../ui/js/landingpage.js"></script>
</body>
</html>