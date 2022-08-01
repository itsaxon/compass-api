package ${package.Mapper};

import com.trinasolar.csde.epm.api.contract.annotation.DataScopeAnnotation;
import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.apache.ibatis.annotations.Mapper;

/**
 * ${table.comment!} Mapper 接口
 *
 * @author ${author}
 * @date ${date}
 */
<#if kotlin>
    interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
@Mapper
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
