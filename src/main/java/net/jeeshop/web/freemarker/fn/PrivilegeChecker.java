package net.jeeshop.web.freemarker.fn;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import net.jeeshop.web.util.RequestHolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dylan on 15-1-19.
 */
@Component("fn.privilegeChecker")
public class PrivilegeChecker implements TemplateMethodModelEx {
    private static Logger logger = LoggerFactory.getLogger(PrivilegeChecker.class);
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if(arguments == null || arguments.size() == 0){
            return true;
        }
        if(!(arguments.get(0) instanceof String)){
            return true;
        }
        String res = (String)arguments.get(0);
        if(StringUtils.isBlank(res)){
            return true;
        }
        HttpSession session = RequestHolder.getSession();
        logger.info("check privilege ,res : {}, session id :{}", res, session == null ? null : session.getId());
        return true;
    }
}
