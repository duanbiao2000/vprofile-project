package com.visualpathit.account.setup;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class StandaloneMvcTestViewResolver extends InternalResourceViewResolver {

    public StandaloneMvcTestViewResolver() {
        super();
    }

    /**
     * Builds and customizes the InternalResourceView for the given view name.
     *
     * <p>This overridden method is used to modify the default behavior of the
     * view resolution process in Spring MVC. It prevents the view resolver from
     * checking for circular view paths, which can be useful in certain scenarios
     * where the view resolution logic is more complex or when using template engines.</p>
     *
     * @param viewName the name of the view to be resolved.
     * @return an instance of InternalResourceView with customized properties.
     * @throws Exception if an error occurs during the view building process.
     */
    @Override
    protected AbstractUrlBasedView buildView(final String viewName) throws Exception {
        final InternalResourceView view = (InternalResourceView) super.buildView(viewName);
        // prevent checking for circular view paths
        view.setPreventDispatchLoop(false);
        // 将配置好的视图返回给Spring MVC
        return view;
    }
}
