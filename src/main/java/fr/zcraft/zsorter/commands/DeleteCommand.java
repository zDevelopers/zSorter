package fr.zcraft.zsorter.commands;

import fr.zcraft.zlib.components.commands.CommandException;
import fr.zcraft.zlib.components.commands.CommandInfo;
import fr.zcraft.zlib.components.i18n.I;
import fr.zcraft.zsorter.ZSorter;
import fr.zcraft.zsorter.ZSorterException;

/**
 * Command triggered to remove a sorter.
 * @author Lucas
 */
@CommandInfo (name = "delete", usageParameters = "<name>")
public class DeleteCommand extends ZSorterCommands{
	
    @Override
    protected void run() throws CommandException {
    	checkEnable();

    	//Check the number of arguments
    	if (args.length < 1)
    		throwInvalidArgument(I.t("A sorter name is required."));

        //Get the name
        String name = args[0];
        
    	try {
    		ZSorter.getInstance().getSorterManager().deleteSorter(name);
    		success(I.t("The sorter has been removed."));
    	} catch (ZSorterException e) {
    		error(e.getMessage());
    	}
    }
}
