package study.jaspertest.service;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import study.jaspertest.dto.TestDto;
import study.jaspertest.entity.ErrStatus;
import study.jaspertest.entity.PieData;
import study.jaspertest.repository.ChartsDataRepository;
import study.jaspertest.repository.InfoRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SampleService {

  private final InfoRepository infoRepository;
  private final ChartsDataRepository chartsDataRepository;

  public void getPdf(OutputStream os) throws FileNotFoundException, JRException {

    File file = ResourceUtils.getFile("classpath:report/sample.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("title", "Title 타이틀");
    paramMap.put("infoDatasource", infoRepository.findAll());
    paramMap.put("chartDatasource", chartsDataRepository.findAll());

    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramMap, new JREmptyDataSource());

    JasperExportManager.exportReportToPdfStream(jasperPrint, os);
  }

  public void getExcel(OutputStream os) throws FileNotFoundException, JRException {

    File file = ResourceUtils.getFile("classpath:report/sample.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("title", "Title 타이틀");
    paramMap.put("infoDatasource", infoRepository.findAll());
    paramMap.put("chartDatasource", chartsDataRepository.findAll());

    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramMap, new JREmptyDataSource());

    SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
    config.setOnePagePerSheet(false);
    config.setIgnoreGraphics(false);

    JRXlsxExporter exporter = new JRXlsxExporter();
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
    exporter.setConfiguration(config);
    exporter.exportReport();
  }

  public void getPdf2(OutputStream os) throws FileNotFoundException, JRException {

    File file = ResourceUtils.getFile("classpath:report/DataAnalysis.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

    Map<String, Object> paramMap = getSampleMap();

    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramMap, new JREmptyDataSource());

    JasperExportManager.exportReportToPdfStream(jasperPrint, os);
  }

  public void getExcel2(OutputStream os) throws FileNotFoundException, JRException {

    File file = ResourceUtils.getFile("classpath:report/DataAnalysis.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

    Map<String, Object> paramMap = getSampleMap();

    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramMap, new JREmptyDataSource());

    SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
    config.setOnePagePerSheet(false);
    config.setIgnoreGraphics(false);

    JRXlsxExporter exporter = new JRXlsxExporter();
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
    exporter.setConfiguration(config);
    exporter.exportReport();
  }

  // PDF 출력
  public void getPdfTest(OutputStream os) throws FileNotFoundException, JRException {
    // jrxml 파일 가져오기
    File file = ResourceUtils.getFile("classpath:report/test.jrxml");
    // jrxml 컴파일
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

    // 샘플 데이터
    List<TestDto> sampleList = new ArrayList<>();
    sampleList.add(new TestDto(1, "테스트 데이터1"));
    sampleList.add(new TestDto(2, "테스트 데이터2"));
    sampleList.add(new TestDto(3, "테스트 데이터3"));
    sampleList.add(new TestDto(4, "테스트 데이터4"));

    // 리포트로 넘길 파라미터
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("chartDatasource", chartsDataRepository.findAll());
    paramMap.put("listDatasource", sampleList);

    // report 채우기
    // * 메인 datasource의 field를 사용할 경우 JREmptyDataSource 대신 JRBeanCollectionDataSource(객체) 사용
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramMap, new JREmptyDataSource());

    // OutputStream으로 출력
    JasperExportManager.exportReportToPdfStream(jasperPrint, os);
  }

  public void getExcelTest(OutputStream os) throws FileNotFoundException, JRException {
    // jrxml 파일 가져오기
    File file = ResourceUtils.getFile("classpath:report/test.jrxml");
    // jrxml 컴파일
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

    // 샘플 데이터
    List<TestDto> sampleList = new ArrayList<>();
    sampleList.add(new TestDto(1, "테스트 데이터1"));
    sampleList.add(new TestDto(2, "테스트 데이터2"));
    sampleList.add(new TestDto(3, "테스트 데이터3"));
    sampleList.add(new TestDto(4, "테스트 데이터4"));

    // 리포트로 넘길 파라미터
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("chartDatasource", chartsDataRepository.findAll());
    paramMap.put("listDatasource", sampleList);

    // report 채우기
    // * 메인 datasource의 field를 사용할 경우 JREmptyDataSource 대신 JRBeanCollectionDataSource(객체) 사용
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramMap, new JREmptyDataSource());

    // excel config 객체 생성 후 설정
    SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
    config.setOnePagePerSheet(false);
    config.setIgnoreGraphics(false);

    // Exporter 생성
    JRXlsxExporter exporter = new JRXlsxExporter();

    // input/output 설정
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
    // config 설정
    exporter.setConfiguration(config);
    // 출력
    exporter.exportReport();
  }

  private Map<String, Object> getSampleMap() {
    Map<String, Object> paramMap = new HashMap<>();

    // 샘플 데이터
    List<ErrStatus> errStatusList = new ArrayList<>();
    errStatusList.add(new ErrStatus(1L, "Sensor1", "2023-01-01 ~ 2023-01-07", 2));
    errStatusList.add(new ErrStatus(2L, "Sensor2", "2023-01-01 ~ 2023-01-07", 3));
    errStatusList.add(new ErrStatus(3L, "Sensor3", "2023-01-01 ~ 2023-01-07", 4));
    errStatusList.add(new ErrStatus(4L, "Sensor4", "2023-01-01 ~ 2023-01-07", 5));
    errStatusList.add(new ErrStatus(5L, "Sensor5", "2023-01-01 ~ 2023-01-07", 6));

    List<PieData> pieDataList = new ArrayList<>();
    pieDataList.add(new PieData("Data1", 20));
    pieDataList.add(new PieData("Data2", 20));
    pieDataList.add(new PieData("Data3", 10));
    pieDataList.add(new PieData("Data4", 50));

    paramMap.put("errStatusDatasource", errStatusList);
    paramMap.put("pieDatasource", pieDataList);
    paramMap.put("chartDatasource", chartsDataRepository.findAll());

    paramMap.put("shipType", "상륙함");
    paramMap.put("shipName", "독도함");
    paramMap.put("equipmentName", "레이더");
    paramMap.put("equipmentCode", "12345");
    paramMap.put("equipmentRunningTime", "9999");
    paramMap.put("reporter", "홍길동");
    paramMap.put("analysisPeriod", "2023-01-01 ~ 2023-01-31");
    paramMap.put("statusBasedReportNumber", "123455");

    paramMap.put("errStatusDesc", "이상 현상 내용 12345");
    paramMap.put("analysisResult", "분석 결과 ~~~~~~~~~~1\r ~~~ ~~2\n~ ~~~~~~ 3\t~~~~~~~~~~~~~~~~ ~~~~~~~~~~~adsadasdnsanakjsnk jdnkdanlkankljanlkjadnjlkd snkjladsnjkldanjlkdasnlkjadsnklj");
    paramMap.put("fyi", "참고 내용 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~nqwnlenasdjkjnqwejasbjdhgkljhgwehkjsadghgkjqweghkjajhksdjkhgqhgjwkejkhgasdgjhkasdghjkgjhaksd");

    paramMap.put("remoteDate", "2023-01-31");
    paramMap.put("supportDepartment", "부서1");
    paramMap.put("supportDesc", "지원내용~~~~~~~");
    paramMap.put("supportResult", "Success");
    paramMap.put("supportYn", "O");

    return paramMap;
  }

}
