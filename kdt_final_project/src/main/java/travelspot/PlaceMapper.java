package travelspot;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper 	//매퍼 파일이야, @MapperScan 필요 
@Repository //객체 생성, @ComponentScan 필요
public interface PlaceMapper {
	 public void insertPlaces(int areaCode);
}
