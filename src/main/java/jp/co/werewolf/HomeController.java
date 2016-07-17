package jp.co.werewolf;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import jp.co.werewolf.dao.TableDao;
import jp.co.werewolf.dao.UserTableDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private TableDao dao;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * URL: http://localhost:8080/werewolf/makeRoom/
	 */
	@RequestMapping(value = "/makeRoom/", method = RequestMethod.GET)
	public String makeRoom(Locale locale, Model model) {

		logger.info("Welcome home! The client locale is {}.", locale);

		model.addAttribute("name", "S.funaki" );

		/**
		 * DBアクセス例
		 * point1 daoは@Autowiredで生成する必要がある。
		 * 第2引数は取得するテーブルの名前。
		 * 第1引数は取得結果を保持したいDtoのクラス
		 * 　SQL取得結果は引数に指定したクラスのメンバ変数と名前が一致するものを
		 * 　自動的にセットしてくれる（ジェネリックメソッドというjavaの仕組みを利用）
		 *　 ただし、SQLはスネーク、Dto側はキャメルで変数を記載する
		 */
		List<UserTableDto> userList = dao.selectAll(UserTableDto.class, "USER");

		for(UserTableDto rec : userList){
			logger.info("UserId_:" + rec.getUserId());
			logger.info("UserName_:" + rec.getUserName());
		}

		return "makeRoom";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}

}
