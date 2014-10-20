package odml.core;

import java.io.Serializable;
import java.util.ArrayList;

import org.jdom.Element;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.w3c.dom.NodeList;

// TODO: Auto-generated Javadoc
/**
 * The {@link GUIHelper} class is extension for {@link Property} class. It adds
 * additional GUI features to Property:
 * <ol>
 * <li>required - is this property required</li>
 * <li>editable - is this property editable</li>
 * <li>defaultValue - is this property default value</li>
 * <li>minValue - minimal possible value for {@link Value} of exact property</li>
 * <li>maxValue - maximal possible value for {@link Value} of exact property</li>
 * <li>list - list of all possible values separated by semicolon</li>
 * <li>order - a number of property in the list of properties to order
 * properties of exact section</li>
 * <li>empty - is value empty</li>
 * </ol>
 * 
 * @author Anubhav
 * 
 */
public class GUIHelper implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4958007652211759849L;
	public static final String LIST_DELIMITER = ";&;";

	private Boolean required;
	private Boolean editable;
	private Boolean empty;
	private Double minValue;
	private Double maxValue;
	private Integer minLength;
	private Integer maxLength;
	private String defaultValue;
	private LocalDate minDate;
	private LocalTime minTime;
	private LocalDate maxDate;
	private LocalTime maxTime;
	private Double stepSize;

	private String list;
	private boolean isListActive;
	private String listUnits;
	private boolean isListUnitsActive;

	private Integer order;
	
	private String label;
	private String datatype;

	public GUIHelper() {
		editable = Boolean.valueOf(true);
		empty = Boolean.valueOf(false);
		required = Boolean.valueOf(false);
		defaultValue = null;
		minValue = null;
		maxValue = null;
		minLength = null;
		maxLength = null;
		stepSize = null;

		minDate = null;
		minTime = null;
		maxDate = null;
		maxTime = null;
		
		list = null;
		isListActive=false;
		
		listUnits = null;
		isListUnitsActive = false;
		
		label = null;
		datatype = null;
	}

	public GUIHelper(org.w3c.dom.Element domProperty)
	{
		this();
		{
			String s_gui_editable = getDirectChildContent(domProperty,
					"gui:editable");
			if (s_gui_editable != null)
				setEditable(s_gui_editable
						.equalsIgnoreCase("true"));
		}

		{
			String s_gui_required = getDirectChildContent(domProperty,
					"gui:required");
			if (s_gui_required != null)
				setRequired(s_gui_required
						.equalsIgnoreCase("true"));
		}

		{
			String s_gui_default = getDirectChildContent(domProperty,
					"gui:default");
			String gui_default = null;
			if (s_gui_default != null)
				gui_default = s_gui_default;
			setDefaultValue(gui_default);
		}

		{
			String s_gui_minval = getDirectChildContent(domProperty,
					"gui:minValue");
			if (s_gui_minval != null)
				setMinValue(Double.parseDouble(s_gui_minval));
		}

		{
			String s_gui_maxval = getDirectChildContent(domProperty,
					"gui:maxValue");
			if (s_gui_maxval != null)
				setMaxValue(Double.parseDouble(s_gui_maxval));
		}

		{
			String s_gui_minlen = getDirectChildContent(domProperty,
					"gui:minLength");
			if (s_gui_minlen != null)
				setMinLength(Integer.parseInt(s_gui_minlen));
		}

		{
			String s_gui_maxlen = getDirectChildContent(domProperty,
					"gui:maxLength");
			if (s_gui_maxlen != null)
				setMaxLength(Integer.parseInt(s_gui_maxlen));
		}

		{
			String s_gui_maxdate = getDirectChildContent(domProperty,
					"gui:maxDate");
			if (s_gui_maxdate != null)
				setMaxDate(new LocalDate(s_gui_maxdate));
		}

		{
			String s_gui_mindate = getDirectChildContent(domProperty,
					"gui:minDate");
			if (s_gui_mindate != null)
				setMinDate(new LocalDate(s_gui_mindate));
		}

		{
			String s_gui_maxtime = getDirectChildContent(domProperty,
					"gui:maxTime");
			if (s_gui_maxtime != null)
				setMaxTime(new LocalTime(s_gui_maxtime));
		}

		{
			String s_gui_mintime = getDirectChildContent(domProperty,
					"gui:minTime");
			if (s_gui_mintime != null)
				setMinTime(new LocalTime(s_gui_mintime));
		}

		{
			String s_gui_list = getDirectChildContent(domProperty,
					"gui:list");
			if (s_gui_list != null)
				setList(s_gui_list);
		}
		
		{
			String s_gui_unit_list = getDirectChildContent(domProperty,
					"gui:listUnits");
			if (s_gui_unit_list != null)
				setListUnits(s_gui_unit_list);
		}

		{
			String s_gui_order = getDirectChildContent(domProperty,
					"gui:order");
			if (s_gui_order != null)
				setOrder(Integer.parseInt(s_gui_order));
		}
		
		{
			String s_gui_stepSize = getDirectChildContent(domProperty,
					"gui:stepSize");
			if (s_gui_stepSize != null)
				setStepSize(Double.parseDouble(s_gui_stepSize));
		}
		
		{
			String s_gui_label = getDirectChildContent(domProperty,
					"gui:label");
			if (s_gui_label != null)
				setLabel(s_gui_label);
		}
		
		{
			String s_gui_datatype = getDirectChildContent(domProperty,
					"gui:datatype");
			if (s_gui_datatype != null)
				setDatatype(s_gui_datatype);
		}
	}
	
	private String getDirectChildContent(org.w3c.dom.Element element, String elementName) {
		String content = null;
		NodeList l = element.getElementsByTagName(elementName);
		for (int i = 0; i < l.getLength(); i++) {
			if (l.item(i).getParentNode().isSameNode(element)) {
				content = l.item(i).getTextContent();
				return content;
			}
		}
		return content;
	}
	
	public String getDefaultValue() {
		return defaultValue;
	}

	public Boolean getEditable() {
		return editable;
	}

	public Boolean getEmpty() {
		return empty;
	}

	public String getList() {
		return list;
	}

	public String getListUnits() {
		return listUnits;
	}

	public LocalDate getMaxDate() {
		return maxDate;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public LocalTime getMaxTime() {
		return maxTime;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public LocalDate getMinDate() {
		return minDate;
	}

	public Integer getMinLength() {
		return minLength;
	}

	public LocalTime getMinTime() {
		return minTime;
	}

	public Double getMinValue() {
		return minValue;
	}

	public Integer getOrder() {
		return order;
	}

	public Boolean getRequired() {
		return required;
	}

	public boolean isListActive() {
		return isListActive;
	}

	public boolean isListUnitsActive() {
		return isListUnitsActive;
	}

	public boolean isValidDate(LocalDate date) {
		if (minDate != null)
			if (date.isBefore(minDate))
				return false;

		if (maxDate != null)
			if (date.isAfter(maxDate))
				return false;

		return true;
	}

	public boolean isValidNumber(Double number) {
		if (minValue != null)
			if (number < minValue)
				return false;

		if (maxValue != null)
			if (number > maxValue)
				return false;

		return true;
	}

	public boolean isValidString(String input) {
		if (minLength != null) {
			if (input.length() < minLength)
				return false;
		}
		if (maxLength != null) {
			if (input.length() > maxLength)
				return false;
		}

		return true;
	}

	public boolean isValidTime(LocalTime time) {
		if (minTime != null)
			if (time.isBefore(minTime))
				return false;

		if (maxTime != null)
			if (time.isAfter(maxTime))
				return false;

		return true;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}

	public void setList(String list) {
		this.list = list;
	}

	public void setListActive(boolean isListActive) {
		this.isListActive = isListActive;
	}

	public void setListUnits(String listUnits) {
		this.listUnits = listUnits;
	}

	public void setListUnitsActive(boolean isListUnitsActive) {
		this.isListUnitsActive = isListUnitsActive;
	}

	public void setMaxDate(LocalDate maxDate) {
		this.maxDate = maxDate;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public void setMaxTime(LocalTime maxTime) {
		this.maxTime = maxTime;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public void setMinDate(LocalDate minDate) {
		this.minDate = minDate;
	}

	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}

	public void setMinTime(LocalTime minTime) {
		this.minTime = minTime;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Double getStepSize() {
		return stepSize;
	}

	public void setStepSize(Double stepSize) {
		this.stepSize = stepSize;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getDatatype() {
		return datatype;
	}
	
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	
	public ArrayList<Element> getGUINamespaceTags()
	{
		ArrayList<Element> tags = new ArrayList<Element>();
		
		Element required = new Element("required", "gui",
				"http://www.g-node.org/guiml");
		Boolean required_ = getRequired();
		if (required_ != null) {
			required.setText(required_.toString());
			tags.add(required);
		}

		Element editable = new Element("editable", "gui",
				"http://www.g-node.org/guiml");
		Boolean editable_ = getEditable();
		if (editable_ != null) {
			editable.setText(editable_.toString());
			tags.add(editable);
		}

		Element defaultValue = new Element("default", "gui",
				"http://www.g-node.org/guiml");
		String defaultVal_ = getDefaultValue();
		if (defaultVal_ != null) {
			defaultValue.setText(defaultVal_);
			tags.add(defaultValue);
		}

		Element minValue = new Element("minValue", "gui",
				"http://www.g-node.org/guiml");
		Double minValue_ = getMinValue();
		if (minValue_ != null) {
			minValue.setText(minValue_.toString());
			tags.add(minValue);
		}

		Element maxValue = new Element("maxValue", "gui",
				"http://www.g-node.org/guiml");
		Double maxValue_ = getMaxValue();
		if (maxValue_ != null) {
			maxValue.setText(maxValue_.toString());
			tags.add(maxValue);
		}

		Element minLength = new Element("minLength", "gui",
				"http://www.g-node.org/guiml");
		Integer minLength_ = getMinLength();
		if (minLength_ != null) {
			minLength.setText(minLength_.toString());
			tags.add(minLength);
		}

		Element maxLength = new Element("maxLength", "gui",
				"http://www.g-node.org/guiml");
		Integer maxLength_ = getMaxLength();
		if (maxLength_ != null) {
			maxLength.setText(maxLength_.toString());
			tags.add(maxLength);
		}

		Element maxDate = new Element("maxDate", "gui",
				"http://www.g-node.org/guiml");
		LocalDate maxDate_ = getMaxDate();
		if (maxDate_ != null) {
			maxDate.setText(maxDate_.toString());
			tags.add(maxDate);
		}

		Element minDate = new Element("minDate", "gui",
				"http://www.g-node.org/guiml");
		LocalDate minDate_ = getMinDate();
		if (minDate_ != null) {
			minDate.setText(minDate_.toString());
			tags.add(minDate);
		}

		Element maxTime = new Element("maxTime", "gui",
				"http://www.g-node.org/guiml");
		LocalTime maxTime_ = getMaxTime();
		if (maxTime_ != null) {
			maxTime.setText(maxTime_.toString("HH:mm:ss"));
			tags.add(maxTime);
		}

		Element minTime = new Element("minTime", "gui",
				"http://www.g-node.org/guiml");
		LocalTime minTime_ = getMinTime();
		if (minTime_ != null) {
			minTime.setText(minTime_.toString("HH:mm:ss"));
			tags.add(minTime);
		}

		Element list = new Element("list", "gui", "http://www.g-node.org/guiml");
		String list_ = getList();
		if (list_ != null) {
			list.setText(list_.toString());
			tags.add(list);
		}
		
		Element list_units = new Element("listUnits", "gui", "http://www.g-node.org/guiml");
		String list_units_ = getListUnits();
		if (list_units_ != null) {
			list_units.setText(list_units_.toString());
			tags.add(list_units);
		}
		
		Element order = new Element("order", "gui",
				"http://www.g-node.org/guiml");
		Integer order_ = getOrder();
		if (order_ != null) {
			order.setText(order_.toString());
			tags.add(order);
		}
		
		Element stepSize = new Element("stepSize", "gui",
				"http://www.g-node.org/guiml");
		Double stepSize_ = getStepSize();
		if (stepSize_ != null) {
			stepSize.setText(stepSize_.toString());
			tags.add(stepSize);
		}
		
		Element label = new Element("label", "gui",
				"http://www.g-node.org/guiml");
		String label_ = getLabel();
		if (label_ != null) {
			label.setText(label_.toString());
			tags.add(label);
		}
		
		Element datatype = new Element("datatype", "gui",
				"http://www.g-node.org/guiml");
		String datatype_ = getDatatype();
		if (datatype_ != null) {
			datatype.setText(datatype_.toString());
			tags.add(datatype);
		}
		
		return tags;
	}
}
