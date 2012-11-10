package utilities;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ImageFilter extends FileFilter{

	private String[] acceptedFiles = {"jpg", "jpeg", "png", "gif"};
	
	@Override
	public boolean accept(File f) {
		if(f.isDirectory())
			return true;
		String filetype = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf(".") + 1);
		for (int i = 0; i < acceptedFiles.length; i++) 
			if(filetype.equalsIgnoreCase(acceptedFiles[i]))
				return true;
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
