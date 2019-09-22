package login.resources;

import com.github.gwtbootstrap.client.ui.config.Configurator;
import com.github.gwtbootstrap.client.ui.resources.Resources;
import com.google.gwt.core.client.GWT;

public class TestConfigurator implements Configurator {
  public Resources getResources() {
    return GWT.create(TestResource.class);
  }

  public boolean hasResponsiveDesign() {
    return true;
  }
}
