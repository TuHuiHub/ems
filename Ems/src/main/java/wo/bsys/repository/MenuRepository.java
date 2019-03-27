package wo.bsys.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import wo.bsys.po.Menu;

/**
 * 实体Menu基于spring-data的DAO接口.
 * @author 
 */
public interface MenuRepository extends PagingAndSortingRepository<Menu, java.lang.String>{
	
	Page<Menu> findAllBynameLike(java.lang.String searchContent, Pageable pageInput);

	int deleteByIdIn(String[] id);

	List<Menu> findAllByParentIdIsNullOrderByNo();
	
	/**
	 * @param ids
	 * @return
	 */
	@Query("select r.menus from Role r where r.id in ?1")
	List<Menu> findAllMenusByRoleIds (List<String> ids);

	List<Menu> findAllByOrderByNo();
}
