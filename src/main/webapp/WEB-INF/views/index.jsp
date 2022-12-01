<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>complete responsive coffee website design tutorial</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
    
<!-- header section starts  -->

<header class="header">

    <div id="menu-btn" class="fas fa-bars"></div>

    <a href="#" class="logo"> coffee <i class="fas fa-mug-hot"></i> </a>

    <nav class="navbar">
        <a href="#home">home</a>
        <a href="#about">about</a>
        <a href="#menu">menu</a>
        <a href="#review">review</a>
        <a href="#book">book</a>
		<a href="/accounts/login">login</a>
		<a href="/accounts/register">register</a>
		<a href="contact">Contact</a> <a href="about">About</a>
    </nav>

    <a href="#" class="btn">book a table</a>

</header>

<!-- header section ends -->

<!-- home section starts  -->

<section class="home" id="home">

    <div class="row">

        <div class="content">
            <h3>fresh coffee in the morning</h3>
            <a href="#" class="btn">buy one now</a>
        </div>

        <div class="image">
            <img src="image/home-img-1.png" class="main-home-image" alt="">
        </div>

    </div>

    <div class="image-slider">
        <img src="image/home-img-1.png" alt="">
        <img src="image/home-img-2.png" alt="">
        <img src="image/home-img-3.png" alt="">
    </div>

</section>

<!-- home section ends -->

<!-- about section starts  -->

<section class="about" id="about">

    <h1 class="heading"> about us <span>why choose us</span> </h1>    

    <div class="row">

        <div class="image">
            <img src="image/about-img.png" alt="">
        </div>

        <div class="content">
            <h3 class="title">what's make our coffee special!</h3>
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Esse et commodi, ad, doloremque obcaecati maxime quam minima dolore mollitia saepe quos, debitis incidunt. Itaque possimus adipisci ipsam harum at autem.</p>
            <a href="#" class="btn">read more</a>
            <div class="icons-container">
                <div class="icons">
                    <img src="image/about-icon-1.png" alt="">
                    <h3>quality coffee</h3>
                </div>
                <div class="icons">
                    <img src="image/about-icon-2.png" alt="">
                    <h3>our branches</h3>
                </div>
                <div class="icons">
                    <img src="image/about-icon-3.png" alt="">
                    <h3>free delivery</h3>
                </div>
            </div>
        </div>

    </div>

</section>

<!-- about section ends -->

<!-- menu section starts  -->

<section class="menu" id="menu">

    <h1 class="heading"> our menu <span>popular menu</span> </h1>

    <div class="box-container">

        <a href="#" class="box">
            <img src="image/menu-1.png" alt="">
            <div class="content">
                <h3>our special coffee</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Magnam, id.</p>
                <span>$8.99</span>
            </div>
        </a>

        <a href="#" class="box">
            <img src="image/menu-2.png" alt="">
            <div class="content">
                <h3>our special coffee</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Magnam, id.</p>
                <span>$8.99</span>
            </div>
        </a>

        <a href="#" class="box">
            <img src="image/menu-3.png" alt="">
            <div class="content">
                <h3>our special coffee</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Magnam, id.</p>
                <span>$8.99</span>
            </div>
        </a>

        <a href="#" class="box">
            <img src="image/menu-4.png" alt="">
            <div class="content">
                <h3>our special coffee</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Magnam, id.</p>
                <span>$8.99</span>
            </div>
        </a>

        <a href="#" class="box">
            <img src="image/menu-5.png" alt="">
            <div class="content">
                <h3>our special coffee</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Magnam, id.</p>
                <span>$8.99</span>
            </div>
        </a>

        <a href="#" class="box">
            <img src="image/menu-6.png" alt="">
            <div class="content">
                <h3>our special coffee</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Magnam, id.</p>
                <span>$8.99</span>
            </div>
        </a>

    </div>

</section>

<!-- menu section ends -->

<!-- review section starts  -->

<section class="review" id="review">

    <h1 class="heading"> reviews <span>what people says</span> </h1>

    <div class="swiper review-slider">

        <div class="swiper-wrapper">

            <div class="swiper-slide box">
                <i class="fas fa-quote-left"></i>
                <i class="fas fa-quote-right"></i>
                <img src="image/pic-1.png" alt="">
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore aliquid eveniet qui, similique aut sit.</p>
                <h3>john deo</h3>
                <span>satisfied client</span>
            </div>

            <div class="swiper-slide box">
                <i class="fas fa-quote-left"></i>
                <i class="fas fa-quote-right"></i>
                <img src="image/pic-2.png" alt="">
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore aliquid eveniet qui, similique aut sit.</p>
                <h3>john deo</h3>
                <span>satisfied client</span>
            </div>

            <div class="swiper-slide box">
                <i class="fas fa-quote-left"></i>
                <i class="fas fa-quote-right"></i>
                <img src="image/pic-3.png" alt="">
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore aliquid eveniet qui, similique aut sit.</p>
                <h3>john deo</h3>
                <span>satisfied client</span>
            </div>

            <div class="swiper-slide box">
                <i class="fas fa-quote-left"></i>
                <i class="fas fa-quote-right"></i>
                <img src="image/pic-4.png" alt="">
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore aliquid eveniet qui, similique aut sit.</p>
                <h3>john deo</h3>
                <span>satisfied client</span>
            </div>

        </div>

        <div class="swiper-pagination"></div>

    </div>

</section>

<!-- review section ends -->

<!-- book section starts  -->

<section class="book" id="book">

    <h1 class="heading"> booking <span>reserve a table</span> </h1>

    <form action="">

        <input type="text" placeholder="your name" class="box">
        <input type="email" placeholder="your email" class="box">
        <input type="number" placeholder="your number" class="box">

        <textarea name="" placeholder="your message" class="box" id="" cols="30" rows="10"></textarea>

        <input type="submit" value="send message" class="btn">

    </form>

</section>

<!-- book section ends -->

<!-- footer section starts  -->

<section class="footer">

    <div class="box-container">

        <div class="box">
            <h3>our branches</h3>
            <a href="#"> <i class="fas fa-arrow-right"></i> india </a>
            <a href="#"> <i class="fas fa-arrow-right"></i> USA </a>
            <a href="#"> <i class="fas fa-arrow-right"></i> france </a>
            <a href="#"> <i class="fas fa-arrow-right"></i> africa </a>
            <a href="#"> <i class="fas fa-arrow-right"></i> Japan </a>
        </div>

        <div class="box">
            <h3>quick links</h3>
            <a href="#"> <i class="fas fa-arrow-right"></i> home </a>
            <a href="#"> <i class="fas fa-arrow-right"></i> about </a>
            <a href="#"> <i class="fas fa-arrow-right"></i> menu </a>
            <a href="#"> <i class="fas fa-arrow-right"></i> review </a>
            <a href="#"> <i class="fas fa-arrow-right"></i> book </a>
        </div>

        <div class="box">
            <h3>contact info</h3>
            <a href="#"> <i class="fas fa-phone"></i> +123-456-7890 </a>
            <a href="#"> <i class="fas fa-phone"></i> +111-222-3333 </a>
            <a href="#"> <i class="fas fa-envelope"></i> shaikhanas@gmail.com </a>
            <a href="#"> <i class="fas fa-envelope"></i> mumbai, india = 400104 </a>
        </div>

        <div class="box">
            <h3>contact info</h3>
            <a href="#"> <i class="fab fa-facebook-f"></i> facebook </a>
            <a href="#"> <i class="fab fa-twitter"></i> twitter </a>
            <a href="#"> <i class="fab fa-twitter"></i> twitter </a>
            <a href="#"> <i class="fab fa-instagram"></i> instagram </a>
            <a href="#"> <i class="fab fa-linkedin"></i> linkedin </a>
        </div>

    </div>

    <div class="credit"> creatd by <span>mr. web designer</span> | all rights reserved </div>

</section>

<!-- footer section ends -->



























<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>

<!-- custom js file link  -->
<script src="js/script.js"></script>

</body>
</html>