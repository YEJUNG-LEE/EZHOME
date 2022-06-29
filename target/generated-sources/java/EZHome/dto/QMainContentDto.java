package EZHome.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * EZHome.dto.QMainContentDto is a Querydsl Projection type for MainContentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMainContentDto extends ConstructorExpression<MainContentDto> {

    private static final long serialVersionUID = 1640749640L;

    public QMainContentDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> main_text, com.querydsl.core.types.Expression<String> imgUrl, com.querydsl.core.types.Expression<String> tag, com.querydsl.core.types.Expression<String> category, com.querydsl.core.types.Expression<Integer> view) {
        super(MainContentDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, int.class}, id, title, main_text, imgUrl, tag, category, view);
    }

}

