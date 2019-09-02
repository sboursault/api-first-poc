package poc.sb.codefirst.oas30.config;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.Example;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

//@Component
//@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1000)
public class CustomApiResponsePlugin implements OperationBuilderPlugin {

    @Override
    public void apply(OperationContext context) {
//        Optional<_404> annotation = context.findAnnotation(_404.class);
//        if (annotation.isPresent()) {
//            String comment = annotation.get().value();
//            context.operationBuilder().responseMessages(new HashSet<>(Arrays.asList(
//                    new ResponseMessageBuilder()
//                    .code(404)
//                    .message("not-found")
//                    .examples(Arrays.asList(new Example("media type", comment)))
//                    .build()
//            )));
//        }
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return SwaggerPluginSupport.pluginDoesApply(delimiter);
    }
}
