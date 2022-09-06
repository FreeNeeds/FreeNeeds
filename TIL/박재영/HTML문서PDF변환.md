# HTML문서 PDF로 변환하기

## 예제코드

1. html2canvas.js 설치
2. jspdf.min.js 설치
3. body 밑의 script코드를 이용하여 HTML문서를 PDF로 변환할 수 있다.

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./js/html2canvas.js"></script>
<script src="./js/jspdf.min.js"></script>
<body>
    <button type="button" class="btn btn-primary" id="savePdf" >PDF 저장</button>

    <p id="pdfDiv">
        (PDF 저장 내용)...
    </p>
</body>

<script>
    $(document).ready(function() {
        $('#savePdf').click(function() { // pdf저장 button id

            html2canvas($('#pdfDiv')[0]).then(function(canvas) { //저장 영역 div id

            // 캔버스를 이미지로 변환
            var imgData = canvas.toDataURL('image/png');

            var imgWidth = 190; // 이미지 가로 길이(mm) / A4 기준 210mm
            var pageHeight = imgWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
            var imgHeight = canvas.height * imgWidth / canvas.width;
            var heightLeft = imgHeight;
            var margin = 10; // 출력 페이지 여백설정
            var doc = new jsPDF('p', 'mm');
            var position = 0;

            // 첫 페이지 출력
            doc.addImage(imgData, 'PNG', margin, position, imgWidth, imgHeight);
            heightLeft -= pageHeight;

            // 한 페이지 이상일 경우 루프 돌면서 출력
            while (heightLeft >= 20) {
                position = heightLeft - imgHeight;
                doc.addPage();
                doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
                heightLeft -= pageHeight;
            }

            // 파일 저장
            doc.save('file-name.pdf');


        });

        });


    })
</script>
</html>
```
