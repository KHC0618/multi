package com.multi.shop.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.shop.product.model.dto.ProductDTO;
import com.multi.shop.product.service.ProductService;
import com.multi.shop.product.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductOneServlet
 */
@WebServlet("/product/selectone")
public class ProductOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String noStr = request.getParameter("no");
		
		int no = Integer.parseInt(noStr);
		
		String path = "";
		
		try {
			
			ProductDTO product = productService.selectProduct(no);
			
            List<ProductDTO> productList = new ArrayList<>();
            
            productList.add(product);
            
            request.setAttribute("productlist", productList);
            
            System.out.println(product);
            
            path = "/WEB-INF/views/product/pdetail.jsp";
			
//			ProductDTO product = productService.selectProduct(no);
//			
//			request.setAttribute("p", product);
//			
//			System.out.println(product);
//			
//			path = "/WEB-INF/views/product/pdetail.jsp";
//			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시물 상세 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
