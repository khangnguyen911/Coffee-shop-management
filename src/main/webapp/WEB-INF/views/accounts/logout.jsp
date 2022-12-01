<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>ÄÄng xuáº¥t</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
      integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
      crossorigin="anonymous"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-md-6 mt-5 mx-auto p-3 border rounded">
            <h4>ÄÄng xuáº¥t thÃ nh cÃ´ng</h4>
            <p>TÃ i khoáº£n cá»§a báº¡n ÄÃ£ ÄÆ°á»£c ÄÄng xuáº¥t khá»i há» thá»ng.</p>
            <p>Nháº¥n <a href="login.php">vÃ o ÄÃ¢y</a> Äá» trá» vá» trang ÄÄng nháº­p, hoáº·c trang web sáº½ tá»± Äá»ng chuyá»n hÆ°á»ng sau <span id="counter" class="text-danger">5</span> giÃ¢y ná»¯a.</p>
            <a class="btn btn-success px-5" href="login.jsp">ÄÄng nháº­p</a>
        </div>
      </div>
    </div>
  <script>
      let duration = 5;
      let countDown = 5;
      let id = setInterval(() => {

          countDown --;
          if (countDown >= 0) {
              $('#counter').html(countDown);
          }
          if (countDown == -1) {
              clearInterval(id);
              window.location.href = 'login.php';
          }

      }, 1000);
  </script>
  </body>
</html>
