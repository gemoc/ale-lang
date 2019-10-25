package org.eclipse.emf.ecoretools.conversion

import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.conversion.ValueConverterException

class StringValueConverter extends DefaultTerminalConverters {
	
	@ValueConverter(rule = "STRING")
	override IValueConverter<String> STRING() {
		return new AbstractNullSafeConverter<String>() {
			def _convert(String str) {
				if (str.startsWith("'") && str.endsWith("'")) str else "'" + str + "'"
			}
			
			override protected internalToString(String arg0) {
				return _convert(arg0)
			}
			
			override protected internalToValue(String arg0, INode arg1) throws ValueConverterException {
				return _convert(arg0)
			}
		}
	}
	
}