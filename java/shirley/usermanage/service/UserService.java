package shirley.usermanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import shirley.usermanage.bean.EasyUIResult;
import shirley.usermanage.mapper.UserMapper;
import shirley.usermanage.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public EasyUIResult queryUserList(Integer page,Integer rows) {
		
		//设置分页参数
		PageHelper.startPage(page,rows);
		
		//查询User数据
		Example example = new Example(User.class);
		example.setOrderByClause("updated DESC");//设置排序条件
		List<User> users = this.userMapper.selectByExample(example);
		
		//获取分页后的信息
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		
		return new EasyUIResult(pageInfo.getTotal(),pageInfo.getList());
	}
}
