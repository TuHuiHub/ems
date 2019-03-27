package wo.bsys.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import wo.bsys.po.Dictionary;

/**
 * 实体Dictionary基于spring-data的DAO接口.
 * @author 
 */
public interface DictionaryRepository extends PagingAndSortingRepository<Dictionary, java.lang.String>{
	
	Page<Dictionary> findAllBydicTypeLike(java.lang.String searchContent, Pageable pageInput);

	int deleteByIdIn(String[] id);

	List<Dictionary> findAllBydicType(String string);
}
