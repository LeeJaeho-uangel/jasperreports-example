package study.jaspertest.service;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRJpaDataSource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
//  public void test() {
//    File file = new File("");
//    List<Product> productList = new ArrayList<>();
//    try {
//      JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//      JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productList);
//      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
////      byte[] bytes = JasperExportManager.exportReportToPdfStream(jasperPrint,
//      JRJpaDataSource jrJpaDataSource = new JRJpaDataSource();
//
//    } catch (JRException e) {
//      throw new RuntimeException(e);
//    }
//  }
}
