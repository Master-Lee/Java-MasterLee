Ԫע��
	��ʵ���ǿ���ע�⵽���ע���ϵ�ע�⡣����ע���ע�����Ǿͳ�֮Ϊ���ע�⡣���ע��ͬʱ�߱�Ԫע��Ĺ��ܣ�
	����Ԫע�⣺
		1.@Target��˵����Annotation�����εĶ���Χ��Annotation�ɱ����� packages��types���ࡢ�ӿڡ�ö�١�Annotation���ͣ������ͳ�Ա�����������췽������Ա������ö��ֵ�������������ͱ��ر�������ѭ��������catch������
��������	ȡֵ(ElementType)�У�
��������	CONSTRUCTOR:��������������
��������	FIELD:����������
��������	LOCAL_VARIABLE:���������ֲ�����
��������	METHOD:������������
��������	PACKAGE:����������
��������	PARAMETER:������������
��������	TYPE:���������ࡢ�ӿ�(����ע������) ��enum����
			���磺 
				ע��Table ��������ע���ࡢ�ӿ�(����ע������)
				@Target(ElementType.Tye)
				public @interface Table {
					/**
					 * ���ݱ�����ע�⣬Ĭ��ֵΪ������
					 * @return
					 */
					 public String tableName() default "className";
				}
				
		2.@Retention �����˸�Annotation��������ʱ�䳤�̣�ĳЩAnnotation��������Դ�����У���������������������һЩȴ��������class�ļ��У�������class�ļ��е�Annotation���ܻᱻ��������ԣ�����һЩ��class��װ��ʱ������ȡ����ע�Ⲣ��Ӱ��class��ִ�У���ΪAnnotation��class��ʹ�����Ǳ�����ģ���
			ȡֵ��RetentionPoicy���У�
	��������SOURCE:��Դ�ļ�����Ч����Դ�ļ�������
	��������CLASS:��class�ļ�����Ч����class������
	��������RUNTIME:������ʱ��Ч��������ʱ������
			���磺
				@Target(ElementType.FIELD)
				@Retention(RetentionPolicy.RUNTIME)
				public @interface Column {
					public String name() default "fieldName";
					public String setFuncName() default "setField";
					public String getFuncName() default "getField";
					public boolean defaultDBValue() default false;
				}
				Columnע���RetentionPolicy������ֵ��RUNTIME������ע�⴦�����ͨ�����䣬��ȡ����ע�������ֵ���Ӷ�ȥ��һЩ����ʱ���߼�����
			
��������3.@Documented ���������������͵�annotationӦ�ñ���Ϊ����ע�ĳ����Ա�Ĺ���API����˿��Ա�����javadoc����Ĺ����ĵ�����Documented��һ�����ע�⣬û�г�Ա��

��������4.@Inherited ��һ�����ע�⣬@Inherited������ĳ������ע�������Ǳ��̳еġ����һ��ʹ����@Inherited���ε�annotation���ͱ�����һ��class�������annotation�������ڸ�class������
			����:
				@Inherited
				public @interface Greeting {
					public enum FontColor{BLUE,RED,GREEN};
					String name();
					FontColor fontColor() default FontColor.GREEN;
				}