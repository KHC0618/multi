
package com.multi.shop.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.multi.shop.product.model.dto.CompanyDTO;
import com.multi.shop.product.model.dto.ProductDTO;
import com.multi.shop.product.service.ProductService;
import com.multi.shop.product.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/product/update")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1, // 1MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 15    // 15MB
)
public class ProductUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService productService = new ProductServiceImpl();

    public ProductUpdateServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productId"));
        ProductDTO product;
        try {
            product = productService.selectProduct(id);
            ArrayList<CompanyDTO> companyList = productService.selectCompanyList();

            request.setAttribute("product", product);
            request.setAttribute("companyList", companyList);

            String path = "/WEB-INF/views/product/updateform.jsp";
            request.getRequestDispatcher(path).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"message\": \"서버 에러가 발생했습니다.\"}");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            // 요청에서 파라미터를 읽어와 ProductDTO 객체 생성
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String content = request.getParameter("content");
            int price = Integer.parseInt(request.getParameter("price"));
            String modifyPerson = request.getParameter("modify_person");

            ProductDTO product = new ProductDTO();
            product.setId(id);
            product.setName(name);
            product.setContent(content);
            product.setPrice(price);
            product.setModifyPerson(modifyPerson);

            // 파일 업로드 처리
            Part filePart = request.getPart("img");
            if (filePart != null && filePart.getSize() > 0) {
                String fileName = UUID.randomUUID().toString() + "_" + filePart.getSubmittedFileName();
                String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String filePath = uploadPath + File.separator + fileName;
                filePart.write(filePath);
                product.setImg(fileName); // 이미지 파일명 설정
            }

            // 제품 업데이트
            int isUpdated = productService.updateProduct(product);

            if (isUpdated > 0) {
                response.getWriter().write("{\"message\": \"제품 정보가 성공적으로 업데이트되었습니다.\"}");
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"message\": \"제품 정보 업데이트에 실패했습니다.\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"message\": \"서버 에러가 발생했습니다.\"}");
        }
    }
}
