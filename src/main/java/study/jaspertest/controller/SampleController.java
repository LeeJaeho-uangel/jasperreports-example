package study.jaspertest.controller;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.jaspertest.service.SampleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class SampleController {

  private final SampleService sampleService;

  @GetMapping("/pdf")
  public void testGetPdf(HttpServletRequest request, HttpServletResponse response) {
    // 출력 파일명 지정
    String realFileNm = "test.pdf";
    String header = request.getHeader("User-Agent");
    String docName = "";
    OutputStream os = null;

    try {
      // 브라우저별 설정 부분은 생략
      if (header.contains("MSIE")) {
        docName = URLEncoder.encode(realFileNm, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
      } else if (header.contains("Trident")) {
        docName = URLEncoder.encode(realFileNm, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
      } else if (!header.contains("Chrome")) {
        String var10000;
        if (header.contains("Opera")) {
          var10000 = new String(realFileNm.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
          docName = "\"" + var10000 + "\"";
        } else if (header.contains("Safari")) {
          var10000 = new String(realFileNm.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
          docName = "\"" + var10000 + "\"";
          docName = URLDecoder.decode(docName);
        } else {
          var10000 = new String(realFileNm.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
          docName = "\"" + var10000 + "\"";
          docName = URLDecoder.decode(docName);
        }
      } else {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < realFileNm.length(); ++i) {
          char c = realFileNm.charAt(i);
          if (c > '~') {
            sb.append(URLEncoder.encode("" + c, StandardCharsets.UTF_8));
          } else {
            sb.append(c);
          }
        }

        docName = sb.toString();
      }

      // response에 contentType과 header 아래와 같이 설정
      response.setContentType("application/octet-stream; charset=utf-8");
      response.setHeader("Content-Disposition", "attachment;fileName=\"" + docName + "\";");
      response.setHeader("Content-Transfer-Encoding", "binary");
      response.setCharacterEncoding("UTF-8");
      os = response.getOutputStream();
      
      // 서비스 호출
      sampleService.getPdf2(os);
      // 출력
      os.flush();
    } catch (FileNotFoundException var25) {
      var25.printStackTrace();
    } catch (IOException var26) {
      var26.printStackTrace();
    } catch (JRException e) {
      throw new RuntimeException(e);
    } finally {
      if (os != null) {
        try {
          os.close();
        } catch (IOException var24) {
          var24.printStackTrace();
        }
      }
    }
  }

  @GetMapping("")
  public void testGetPdfView(HttpServletRequest request, HttpServletResponse response) {
    // 출력 파일명 지정
    String realFileNm = "test.pdf";
    String header = request.getHeader("User-Agent");
    String docName = "";
    OutputStream os = null;

    try {
      // 브라우저에 따른 출력 생성 부분은 생략
      if (header.contains("MSIE")) {
        docName = URLEncoder.encode(realFileNm, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
      } else if (header.contains("Trident")) {
        docName = URLEncoder.encode(realFileNm, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
      } else if (!header.contains("Chrome")) {
        String var10000;
        if (header.contains("Opera")) {
          var10000 = new String(realFileNm.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
          docName = "\"" + var10000 + "\"";
        } else if (header.contains("Safari")) {
          var10000 = new String(realFileNm.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
          docName = "\"" + var10000 + "\"";
          docName = URLDecoder.decode(docName);
        } else {
          var10000 = new String(realFileNm.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
          docName = "\"" + var10000 + "\"";
          docName = URLDecoder.decode(docName);
        }
      } else {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < realFileNm.length(); ++i) {
          char c = realFileNm.charAt(i);
          if (c > '~') {
            sb.append(URLEncoder.encode("" + c, StandardCharsets.UTF_8));
          } else {
            sb.append(c);
          }
        }

        docName = sb.toString();
      }

      // response에 contentType과 header 아래와 같이 설정
      response.setContentType("application/pdf; charset=utf-8"); // pdf 화면에 출력시 위 3개 옵션을 주석 걸고 사용
      response.setCharacterEncoding("UTF-8");
      os = response.getOutputStream();
      
      // 서비스 호출
      sampleService.getPdfTest(os);
      // 출력
      os.flush();
    } catch (FileNotFoundException var25) {
      var25.printStackTrace();
    } catch (IOException var26) {
      var26.printStackTrace();
    } catch (JRException e) {
      throw new RuntimeException(e);
    } finally {
      if (os != null) {
        try {
          os.close();
        } catch (IOException var24) {
          var24.printStackTrace();
        }
      }
    }
  }

  @GetMapping("/excel")
  public void testGetExcel(HttpServletRequest request, HttpServletResponse response) {
    // 출력 파일명 지정
    String realFileNm = "test.xlsx";
    String header = request.getHeader("User-Agent");
    String docName = "";
    OutputStream os = null;

    try {
      // 브라우저에 따른 출력 생성 부분은 생략
      if (header.contains("MSIE")) {
        docName = URLEncoder.encode(realFileNm, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
      } else if (header.contains("Trident")) {
        docName = URLEncoder.encode(realFileNm, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
      } else if (!header.contains("Chrome")) {
        String var10000;
        if (header.contains("Opera")) {
          var10000 = new String(realFileNm.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
          docName = "\"" + var10000 + "\"";
        } else if (header.contains("Safari")) {
          var10000 = new String(realFileNm.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
          docName = "\"" + var10000 + "\"";
          docName = URLDecoder.decode(docName);
        } else {
          var10000 = new String(realFileNm.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
          docName = "\"" + var10000 + "\"";
          docName = URLDecoder.decode(docName);
        }
      } else {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < realFileNm.length(); ++i) {
          char c = realFileNm.charAt(i);
          if (c > '~') {
            sb.append(URLEncoder.encode("" + c, StandardCharsets.UTF_8));
          } else {
            sb.append(c);
          }
        }

        docName = sb.toString();
      }

      // response에 contentType과 header 아래와 같이 설정
      response.setContentType("application/octet-stream; charset=utf-8");
      response.setHeader("Content-Disposition", "attachment;fileName=\"" + docName + "\";");
      response.setHeader("Content-Transfer-Encoding", "binary");
      response.setCharacterEncoding("UTF-8");
      os = response.getOutputStream();
      
      // 서비스 호출
      sampleService.getExcelTest(os);
      // 출력
      os.flush();
    } catch (FileNotFoundException var25) {
      var25.printStackTrace();
    } catch (IOException var26) {
      var26.printStackTrace();
    } catch (JRException e) {
      throw new RuntimeException(e);
    } finally {
      if (os != null) {
        try {
          os.close();
        } catch (IOException var24) {
          var24.printStackTrace();
        }
      }
    }
  }
}
