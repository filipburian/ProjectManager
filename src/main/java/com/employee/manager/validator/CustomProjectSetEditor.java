package com.employee.manager.validator;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Component;

import com.employee.manager.service.ProjectService;

@Component
public class CustomProjectSetEditor extends CustomCollectionEditor {

	@Autowired
	ProjectService projectService;
	public CustomProjectSetEditor() {
		super(Set.class);
	}	
		@Override
        protected Object convertElement(Object element)
        {
            Long id = null;

            if(element instanceof String && !((String)element).equals("")){
                try{
                    id = Long.parseLong((String) element);
                }
                catch (NumberFormatException e) {
                    System.out.println("Element was " + ((String) element));
                    e.printStackTrace();
                }
            }
            else if(element instanceof Long) {
                id = (Long) element;
            }
            return id != null ? projectService.getProject(id) : null;
        }
		

}
